package com.sakr.sqlite.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakr.sqlite.DTO.CountryPhoneNumberDTO;
import com.sakr.sqlite.entity.Customer;
import com.sakr.sqlite.repository.CustomerRepository;
import com.sakr.sqlite.service.CustomerService;
import com.sakr.sqlite.utils.CountriesNamesDataUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CountriesNamesDataUtil countriesNamesDataUtil;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CountryPhoneNumberDTO> getCountryPhoneNumbers(String countryName, Boolean status) {

		Map<String, String> countriesCodes = countriesNamesDataUtil.getCountriesCodes();

		List<Customer> getCountriesPhoneNumbersList = customerRepository
				.getCountriesPhoneNumbers("_" + countriesCodes.get(countryName));

		return validateCountryPhoneNumbers(getCountriesPhoneNumbersList, countryName, status);
	}

	@Override
	public List<CountryPhoneNumberDTO> validateCountryPhoneNumbers(List<Customer> customerData, String countryName,
			Boolean status) {

		List<CountryPhoneNumberDTO> countryPhoneNumberDTOList = new ArrayList<>();

		Map<String, String> countriesRegex = countriesNamesDataUtil.getCountriesRegex();

		for (Customer customer : customerData) {

			CountryPhoneNumberDTO countryPhoneNumberDTO = new CountryPhoneNumberDTO();
			countryPhoneNumberDTO.setCountry(countryName);
			countryPhoneNumberDTO.setPhone(customer.getPhone());
			if (Pattern.matches(countriesRegex.get(countryName), customer.getPhone())) {
				countryPhoneNumberDTO.setValid(true);
			} else {
				countryPhoneNumberDTO.setValid(false);

			}
			countryPhoneNumberDTOList.add(countryPhoneNumberDTO);
		}

		return (status == null) ? countryPhoneNumberDTOList
				: filterCountryPhoneNumbers(countryPhoneNumberDTOList, status);
	}

	public List<CountryPhoneNumberDTO> filterCountryPhoneNumbers(List<CountryPhoneNumberDTO> countryPhoneNumberData,
			Boolean status) {

		List<CountryPhoneNumberDTO> filteredCountryPhoneNumberList = new ArrayList<CountryPhoneNumberDTO>();
		for (CountryPhoneNumberDTO countryPhoneNumberDTO : countryPhoneNumberData) {
			if (countryPhoneNumberDTO.getValid() == status) {

				filteredCountryPhoneNumberList.add(countryPhoneNumberDTO);
			}

		}
		return filteredCountryPhoneNumberList;
	}

}
