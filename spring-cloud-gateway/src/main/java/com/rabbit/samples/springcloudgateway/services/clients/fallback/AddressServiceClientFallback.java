package com.rabbit.samples.springcloudgateway.services.clients.fallback;

import com.rabbit.samples.springcloudgateway.services.clients.AddressServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Slf4j
@Component
public class AddressServiceClientFallback
		implements AddressServiceClient {

	@Override
	public String getById(final String id) {

		log.warn("FALLBACK of AddressService.getId(..)");
		return "{}";
	}

}
