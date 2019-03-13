package com.rabbit.samples.springcloudgateway.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
@Configuration
// WARNING: there is no auto-configuration/auto-scan to retrieve Feign clients automatically, so the basePackage must be specified!
@EnableFeignClients("com.rabbit.samples.springcloudgateway.services.clients")
public class FeignConfig {

	// no-op
}
