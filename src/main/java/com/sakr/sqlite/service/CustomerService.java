package com.sakr.sqlite.service;

import java.util.List;

import com.sakr.sqlite.DTO.CountryPhoneNumberDTO;
import com.sakr.sqlite.entity.Customer;

public interface CustomerService {

	List<CountryPhoneNumberDTO> getCountryPhoneNumbers(String countryName, Boolean status);

	List<CountryPhoneNumberDTO> validateCountryPhoneNumbers(List<Customer> customerData, String countryName,
			Boolean status);

	List<CountryPhoneNumberDTO> filterCountryPhoneNumbers(List<CountryPhoneNumberDTO> countryPhoneNumberData,
			Boolean status);

}
