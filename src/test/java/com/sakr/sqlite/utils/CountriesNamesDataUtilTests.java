package com.sakr.sqlite.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountriesNamesDataUtilTest {

	@Autowired
	CountriesNamesDataUtil countriesNamesDataUtil;

	@Test
	void getCountriesCodesTest() {

		assertThat(countriesNamesDataUtil.getCountriesCodes() != null);
		assertThat(countriesNamesDataUtil.getCountriesRegex() != null);

	}

}
