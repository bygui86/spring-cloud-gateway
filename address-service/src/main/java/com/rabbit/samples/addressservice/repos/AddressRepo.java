package com.rabbit.samples.addressservice.repos;

import com.rabbit.samples.addressservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, String> {

	// no-op
}
