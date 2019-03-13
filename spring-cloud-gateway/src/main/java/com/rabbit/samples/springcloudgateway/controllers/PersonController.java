package com.rabbit.samples.springcloudgateway.controllers;

import com.rabbit.samples.springcloudgateway.facades.PersonFacade;
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


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/persons")
public class PersonController {

	PersonFacade personFacade;

	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public String getAll() {

		log.info("get all persons");

		return getPersonFacade()
				.getAll()
				.toString();
	}

	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public String getById(@PathVariable final String id) {

		log.info("get person by id {}", id);

		return getPersonFacade()
				.getById(id)
				.toString();
	}

}
