package com.rabbit.samples.addressservice.controllers;

import com.rabbit.samples.addressservice.domain.Address;
import com.rabbit.samples.addressservice.repos.AddressRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/addresses")
public class AddressController {

	AddressRepo addressRepo;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> getAll() {

		log.info("get all addresses");

		return getAddressRepo().findAll();
	}

	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Address getById(@PathVariable final String id) {

		log.info("get address by id {}", id);

		return getAddressRepo()
				.findById(id)
				.orElse(getErrorAddress(id));
	}

	protected Address getErrorAddress(final String id) {

		return Address.builder().id(id).errorMsg("Address not found").build();
	}

}
