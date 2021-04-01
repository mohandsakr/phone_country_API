package com.sakr.sqlite.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CountriesNamesDataUtil {

	public Map<String, String> countriesRegex = new HashMap<>();
	public Map<String, String> countriesCodes = new HashMap<>();

	public Map<String, String> getCountriesCodes() {

		if (countriesCodes.isEmpty()) {
			countriesCodes.put("Cameroon", "237");
			countriesCodes.put("Ethiopia", "251");
			countriesCodes.put("Morocco", "212");
			countriesCodes.put("Mozambique", "258");
			countriesCodes.put("Uganda", "256");
		}

		return countriesCodes;
	}

	public Map<String, String> getCountriesRegex() {

		if (countriesRegex.isEmpty()) {
			countriesRegex.put("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
			countriesRegex.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
			countriesRegex.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
			countriesRegex.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
			countriesRegex.put("Uganda", "\\(256\\)\\ ?\\d{9}$");

		}

		return countriesRegex;
	}

}
