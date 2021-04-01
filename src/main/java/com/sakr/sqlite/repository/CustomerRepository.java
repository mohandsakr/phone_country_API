package com.sakr.sqlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sakr.sqlite.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = " select c from Customer c where c.phone like  :countryCode% ")
	List<Customer> getCountriesPhoneNumbers(@Param("countryCode") String countryCode);

}
