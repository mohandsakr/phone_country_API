package com.sakr.sqlite.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sakr.sqlite.controller.CountryController;
import com.sakr.sqlite.service.CustomerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CountryController.class)
class CountryControllerTests {

	@MockBean
	CustomerService customerService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void getCountriesCodesTest() throws Exception {

		this.mockMvc.perform(get("/Country")).andExpect(status().isOk());
		this.mockMvc.perform(get("/Country?country-name=Ethiopia")).andExpect(status().isOk());
		this.mockMvc.perform(get("/Country?country-name=Ethiopia?state=true")).andExpect(status().isOk());

	}

}
