package com.sakr.sqlite.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sakr.sqlite.DTO.CountryPhoneNumberDTO;
import com.sakr.sqlite.entity.Customer;

@SpringBootTest
class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;

	@Test
	void getCountryPhoneNumbersTest() {

		assertThat(customerService.getCountryPhoneNumbers("Cameroon", true)).isNotEmpty();
		assertThat(customerService.getCountryPhoneNumbers("Egypt", true)).isEmpty();

	}

	@Test
	void validateCountryPhoneNumbersTest() {

		List<Customer> customerData = new ArrayList<>();
		List<CountryPhoneNumberDTO> validatedCountryPhoneNumbersList = new ArrayList<>();
		Customer customer = new Customer();
		customer.setPhone("(237) 697151594");
		Customer customer2 = new Customer();
		customer2.setPhone("(237) 6A0311634");
		customerData.add(customer);
		customerData.add(customer2);

		validatedCountryPhoneNumbersList = customerService.validateCountryPhoneNumbers(customerData, "Cameroon", true);
		assertThat(validatedCountryPhoneNumbersList.get(0).getValid()).isTrue();

		validatedCountryPhoneNumbersList = customerService.validateCountryPhoneNumbers(customerData, "Cameroon", false);
		assertThat(validatedCountryPhoneNumbersList.get(0).getValid()).isFalse();
	}

	@Test
	void filterCountryPhoneNumbers() {

		List<CountryPhoneNumberDTO> countryPhoneNumberDTOList = new ArrayList<>();
		CountryPhoneNumberDTO validCountryPhoneNumberDTO = new CountryPhoneNumberDTO();
		validCountryPhoneNumberDTO.setPhone("(237) 697151594");
		validCountryPhoneNumberDTO.setCountry("Cameroon");
		validCountryPhoneNumberDTO.setValid(true);

		CountryPhoneNumberDTO notValidCountryPhoneNumberDTO = new CountryPhoneNumberDTO();
		notValidCountryPhoneNumberDTO.setPhone("(237) 6A0311634");
		notValidCountryPhoneNumberDTO.setCountry("Cameroon");
		notValidCountryPhoneNumberDTO.setValid(false);

		countryPhoneNumberDTOList.add(validCountryPhoneNumberDTO);
		countryPhoneNumberDTOList.add(notValidCountryPhoneNumberDTO);

		List<CountryPhoneNumberDTO> validatedCountryPhoneNumbersList = customerService
				.filterCountryPhoneNumbers(countryPhoneNumberDTOList, true);
		assertThat(validatedCountryPhoneNumbersList.size() == 1);
		assertThat(validatedCountryPhoneNumbersList.get(0).getPhone().equals("(237) 697151594"));
	}

}
