package com.rabbit.samples.personservice.repos;

import com.rabbit.samples.personservice.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Repository
public interface PersonRepo extends JpaRepository<Person, String> {

	// no-op
}
