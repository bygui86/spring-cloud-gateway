package com.rabbit.samples.servicea.controllers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Slf4j
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/service-a")
public class ServiceAController {

	@Value("${spring.application.name}")
	String applicationName;

	@GetMapping
	public String hello() {

		log.info("get hello");

		return "Hello from " + getApplicationName().toUpperCase();
	}

}
