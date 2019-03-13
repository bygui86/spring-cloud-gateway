package com.rabbit.samples.personservice.controllers;

import com.rabbit.samples.personservice.domain.Person;
import com.rabbit.samples.personservice.repos.PersonRepo;
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
@RequestMapping("/persons")
public class PersonController {

	PersonRepo personRepo;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getAll() {

		log.info("get all persons");

		return getPersonRepo().findAll();
	}

	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person getById(@PathVariable final String id) {

		log.info("get person by id {}", id);

		return getPersonRepo()
				.findById(id)
				.orElse(getErrorPerson(id));
	}

	protected Person getErrorPerson(final String id) {

		return Person.builder().id(id).errorMsg("Person not found").build();
	}

}
