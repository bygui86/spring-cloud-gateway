package com.rabbit.samples.springcloudgateway.facades;

import org.json.JSONArray;
import org.json.JSONObject;


public interface PersonFacade {

	JSONArray getAll();

	JSONObject getById(final String id);

}
