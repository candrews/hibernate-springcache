Hibernate SpringCache
=====================

[![DevOps By Rultor.com](http://www.rultor.com/b/candrews/hibernate-springcache)](http://www.rultor.com/p/candrews/hibernate-springcache)
[![Build Status](https://travis-ci.org/candrews/hibernate-springcache.svg?branch=master)](https://travis-ci.org/candrews/hibernate-springcache)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.integralblue/hibernate-springcache/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.integralblue/hibernate-springcache)
[![Reference Status](https://www.versioneye.com/java/com.integralblue:hibernate-springcache/reference_badge.svg?style=flat-square)](https://www.versioneye.com/java/com.integralblue:hibernate-springcache/references)
[![Dependency Status](https://www.versioneye.com/java/com.integralblue:hibernate-springcache/badge?style=flat-square)](https://www.versioneye.com/java/com.integralblue:hibernate-springcache)
[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/com.integralblue/hibernate-springcache/badge.svg)](http://www.javadoc.io/doc/com.integralblue/hibernate-springcache)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.integralblue%3Ahibernate-springcache&metric=alert_status)](https://sonarcloud.io/dashboard/index/com.integralblue:hibernate-springcache)

Hibernate SpringCache is a Hibernate cache implementation that backs to the Spring Cache abstraction.
In other words, setup caching once in Spring then use it from Spring and Hibernate so configuration isn't duplicated.

This project has been submitted to Hibernate for inclusion: https://github.com/hibernate/hibernate-orm/pull/1639

Quick Start
===========
* **Minimum requirements** — You'll need Java 1.8+, Hibernate 5.2.6+, and Spring 4.3+. Spring Boot 1.4+ is optional.
* **Download** — Depend on this libary using, for example, Maven:
```xml
  <dependency>
    <groupId>com.integralblue</groupId>
    <artifactId>hibernate-springcache</artifactId>
    <version>[INSERT VERSION HERE]</version>
    <type>jar</type>
  </dependency>
```
* In application.properties, add:
`spring.jpa.properties.hibernate.cache.region.factory_class=com.integralblue.hibernate.cache.springcache.SpringCacheRegionFactory`
* If using Spring Boot, that's it - `com.integralblue.hibernate.cache.springcache.SpringCacheRegionFactoryAutoConfigure` will take care of the rest.
* If not not using Spring boot, the `com.integralblue.hibernate.cache.springcache.SpringCacheRegionFactoryBeanPostProcessor` bean post processor must be registered (add it as a bean using Spring Java or XML configuration).
