package com.sakr.sqlite.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void getCountriesPhoneNumbersTest() {

		assertThat(customerRepository.getCountriesPhoneNumbers("237")).isNotNull();
	}

}
