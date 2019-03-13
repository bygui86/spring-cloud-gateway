package com.rabbit.samples.springcloudgateway.services.impl;

import com.rabbit.samples.springcloudgateway.services.PersonService;
import com.rabbit.samples.springcloudgateway.services.clients.PersonServiceClient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Service
public class PersonServiceImpl implements PersonService {

	PersonServiceClient personServiceClient;

	@Override
	public JSONArray getAll() {

		log.debug("get all persons from external service");

		return new JSONArray(
				getPersonServiceClient().getAll()
		);
	}

	@Override
	public JSONObject getById(final String id) {

		log.debug("get person by id {} from external service", id);

		return new JSONObject(
				getPersonServiceClient().getById(id)
		);
	}

}
