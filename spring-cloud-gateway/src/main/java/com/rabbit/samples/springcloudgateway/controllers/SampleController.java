package com.rabbit.samples.springcloudgateway.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


/**
 * Semantic Response Status
 * Follow standard RESTful practice, we naturally need to make use of the full range of HTTP status codes to express the semantics of the API properly.
 *
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Mar 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/samples")
public class SampleController {

	/**
	 * Default Return Status
	 *
	 * @return
	 */
	@GetMapping(value = "/ok", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Flux<String> ok() {

		return Flux.just("ok");
	}

	/**
	 * Using Annotations
	 *
	 * @return
	 */
	@GetMapping(value = "/no-content", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Flux<String> noContent() {

		return Flux.empty();
	}

	/**
	 * Changing the Status Programmatically
	 *
	 * @param response
	 * @return
	 */
	@GetMapping(value = "/accepted", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Flux<String> accepted(ServerHttpResponse response) {

		response.setStatusCode(HttpStatus.ACCEPTED);
		return Flux.just("accepted");
	}

	/**
	 * Throwing an Exception
	 * See also illegalArgumentHandler() method
	 *
	 * @return
	 */
	@GetMapping(value = "/bad-request")
	public Mono<String> badRequest() {

		return Mono.error(new IllegalArgumentException());
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal arguments")
	@ExceptionHandler(IllegalArgumentException.class)
	public void illegalArgumentHandler() {

		// no-op
	}

	/**
	 * With ResponseEntity
	 *
	 * @return
	 */
	@GetMapping(
			value = "/unauthorized"
	)
	public ResponseEntity<Mono<String>> unathorized() {

		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.header("X-Reason", "user-invalid")
				.body(Mono.just("unauthorized"));
	}

	/**
	 * With Functionals Endpoints
	 *
	 * @return
	 */
	@Bean
	public RouterFunction<ServerResponse> notFound() {

		return RouterFunctions
				.route(
						GET("/samples/not-found"),
						request -> ServerResponse.notFound().build()
				);
	}

}
