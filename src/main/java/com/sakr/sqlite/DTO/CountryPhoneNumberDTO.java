package com.sakr.sqlite.DTO;

import lombok.Data;

@Data
public class CountryPhoneNumberDTO {

	private String country;
	private String phone;
	private Boolean valid;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
