package com.sakr.sqlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sakr.sqlite.DTO.CountryPhoneNumberDTO;
import com.sakr.sqlite.service.CustomerService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String getCountryPhoneNumbers(@RequestParam(value = "country-name", required = false) String countryName,
			@RequestParam(value = "state", required = false) Boolean status, Model model) {

		List<CountryPhoneNumberDTO> countryPhoneNumberDtoList = customerService.getCountryPhoneNumbers(countryName,
				status);
		model.addAttribute("data", countryPhoneNumberDtoList);
		return "Country";

	}

}
