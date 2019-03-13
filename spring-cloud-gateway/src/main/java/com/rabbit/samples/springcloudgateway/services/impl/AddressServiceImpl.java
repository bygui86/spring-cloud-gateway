package com.rabbit.samples.springcloudgateway.services.impl;

import com.rabbit.samples.springcloudgateway.services.AddressService;
import com.rabbit.samples.springcloudgateway.services.clients.AddressServiceClient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Service
public class AddressServiceImpl implements AddressService {

	AddressServiceClient addressServiceClient;

	@Override
	public JSONObject getById(final String id) {

		log.debug("get address by id {} from external service", id);

		return new JSONObject(
				getAddressServiceClient().getById(id)
		);
	}

}
