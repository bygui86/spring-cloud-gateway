package com.rabbit.samples.springcloudgateway.services;

import org.json.JSONArray;
import org.json.JSONObject;


public interface PersonService {

	JSONArray getAll();

	JSONObject getById(final String id);

}
