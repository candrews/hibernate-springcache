/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.integralblue.hibernate.cache.springcache;

import java.util.Map;

import javax.cache.CacheManager;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.jcache.internal.JCacheRegionFactory;

@SuppressWarnings("serial")
public class SpringCacheRegionFactory extends JCacheRegionFactory {

	public static final ThreadLocal<org.springframework.cache.CacheManager> SPRING_CACHE_MANAGER = new InheritableThreadLocal<>();

	private static final String PROP_PREFIX = "hibernate.spring.cache";

	public static final String UNWRAP_JCACHE = PROP_PREFIX + ".unwrap_jcache";

	@Override
	protected CacheManager resolveCacheManager(final SessionFactoryOptions settings, @SuppressWarnings("rawtypes") final Map properties) {
		final org.springframework.cache.CacheManager springCacheManager = SPRING_CACHE_MANAGER.get();
		if(springCacheManager == null){
			throw new IllegalStateException("The Spring Cache Manager to use must be provided");
		}
		final boolean unwrapJcache = Boolean.parseBoolean( (String) properties.get( UNWRAP_JCACHE ) );
		return new SpringCacheManagerToJCacheManagerAdapter( springCacheManager, unwrapJcache );
	}

}
