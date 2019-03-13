package com.rabbit.samples.addressservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 11 Mar 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	String id;

	String street;

	String town;

	String country;

	String errorMsg;

}
