package com.rabbit.samples.springcloudgateway.configs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Configuration
public class GatewayConfig {

	UrlsConfig urlsConfig;

	/**
	 * Redirection to back-services
	 *
	 * @param routeLocatorBuilder
	 * @return
	 */
	@Bean
	RouteLocator gatewayRoutes(final RouteLocatorBuilder routeLocatorBuilder) {

		return routeLocatorBuilder
				.routes()
				.route(
						"service-a",
						predicateSpec -> predicateSpec
								// .host("**.rabbit.com")
								// .and()
								.path("/service-a/**")
								// .filters(f -> f.prefixPath("/path/prefix"))
								.uri(getUrlsConfig().getServiceA())
								// .uri(getUrlsConfig().getServiceB())
				)
				.route(
						"service-b",
						predicateSpec -> predicateSpec
								.path("/service-b/**")
								// .filters(f -> f.hystrix("hystrix-command"))
								.uri(getUrlsConfig().getServiceB())
				)
				.build();
	}

}
