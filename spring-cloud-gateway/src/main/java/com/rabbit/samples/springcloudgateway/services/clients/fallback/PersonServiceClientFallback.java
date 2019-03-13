package com.rabbit.samples.springcloudgateway.services.clients.fallback;

import com.rabbit.samples.springcloudgateway.services.clients.PersonServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Slf4j
@Component
public class PersonServiceClientFallback
		implements PersonServiceClient {

	@Override
	public String getAll(){

		log.warn("FALLBACK of PersonService.getAll()");

		return "[]";
	}

	@Override
	public String getById(final String id){

		log.warn("FALLBACK of PersonService.getById(..)");

		return "{}";
	}

}
