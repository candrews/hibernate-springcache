/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.integralblue.hibernate.cache.springcache;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name="spring.jpa.properties.hibernate.cache.region.factory_class", havingValue="com.integralblue.hibernate.cache.springcache.SpringCacheRegionFactory")
@SuppressWarnings("PMD.ClassNamingConventions")
public class SpringCacheRegionFactoryAutoConfigure {
	@Bean
	protected static SpringCacheRegionFactoryBeanPostProcessor springCacheRegionFactoryBeanPostProcessor(){
		return new SpringCacheRegionFactoryBeanPostProcessor();
	}
}
