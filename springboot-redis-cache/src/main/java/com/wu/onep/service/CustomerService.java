package com.wu.onep.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wu.onep.model.Customer;

@Service
@CacheConfig(cacheNames = {"Customer"})
public class CustomerService {

	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerService.class);
	@Cacheable(key ="#id", value = "Customer")
	public Customer getCustomerDetails(String id) {
		LOGGER.info("Getting customer information id {} ",id);
		return getCustomerList().stream().filter(c->c.getId().equals(id)).findAny().get();
	}
	private List<Customer> getCustomerList() {
	List<Customer> customers=new ArrayList<Customer>();
	customers.add(new Customer("101", "Asheesh", "apatel.sgsist@gmail.com"));
	customers.add(new Customer("102", "Dipika", "dipika.apatel@gmail.com"));
	return customers;
		
	}
}
