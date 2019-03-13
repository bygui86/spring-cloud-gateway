package com.rabbit.samples.springcloudgateway.facades.impl;

import com.rabbit.samples.springcloudgateway.facades.PersonFacade;
import com.rabbit.samples.springcloudgateway.services.AddressService;
import com.rabbit.samples.springcloudgateway.services.PersonService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
public class PersonFacadeImpl implements PersonFacade {

	static final String JSON_NULL_STRING = "null";
	static final String PERSON_ID_KEY = "id";
	static final String ADDRESS_ID_KEY = "addressId";
	static final String ADDRESS_STREET_KEY = "street";
	static final String ERROR_MSG_KEY = "errorMsg";

	AddressService addressService;

	PersonService personService;

	@Override
	public JSONArray getAll() {

		log.debug("get all persons");

		final JSONArray persons = getPersonService().getAll();

		for (int i = 0; i < persons.length(); i++){

			getAndAssociateAddress(
					persons.getJSONObject(i)
			);
		}

		return persons;
	}

	@Override
	public JSONObject getById(final String id) {

		log.debug("get person by id {}", id);

		final JSONObject person = getPersonService().getById(id);
		getAndAssociateAddress(person);
		return person;
	}

	private void getAndAssociateAddress(final JSONObject person) {

		final String personErrorMsg = person.get(ERROR_MSG_KEY) != null ? person.get(ERROR_MSG_KEY).toString() : "";
		final String personAddressId = person.get(ADDRESS_ID_KEY) != null ? person.get(ADDRESS_ID_KEY).toString() : "";

		if((StringUtils.isEmpty(personErrorMsg) || JSON_NULL_STRING.equals(personErrorMsg))
				&& !StringUtils.isEmpty(personAddressId)) {

			log.debug("get address by id {}", personAddressId);

			final JSONObject address = getAddressService().getById(personAddressId);

			person.remove(ADDRESS_ID_KEY);

			final String addressErrorMsg = address.get(ERROR_MSG_KEY) != null ? address.get(ERROR_MSG_KEY).toString() : "";
			if ((StringUtils.isEmpty(addressErrorMsg) || JSON_NULL_STRING.equals(addressErrorMsg))
					&& !StringUtils.isEmpty(address.get(ADDRESS_STREET_KEY))) {
				person.put("address", address);
			} else {
				log.error("Address with id {} has an error: {}", personAddressId, addressErrorMsg);
			}
		} else {
			log.error("Person with id {} has an error: {}", person.get(PERSON_ID_KEY), personErrorMsg);
		}
	}

}
