package com.example.CustomerClint.rest_clint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerClint.pojo.Customer;

@Component
//@ConfigurationProperties(prefix = "customer", ignoreUnknownFields = false)
public class Customer_REST_Clint {

	@Autowired
	RestTemplate restTemplate;

	@Value("${customer.host}")
	private String host;

	private final String getCustomerURL = "/customers/";
	private final String saveCustomerURL = "/customers/";
	private final String updateCustomerURL = "/customers/";
	private final String deleteCustomerURL = "/customers/";

	public Customer getCustomerById(int id) {
		return this.restTemplate.getForObject(this.host + this.getCustomerURL + id, Customer.class);

	}

	public Customer saveCustomer(Customer customer) {
		return this.restTemplate.postForObject(this.host + this.saveCustomerURL, customer, Customer.class);

	}

	public Customer updateCustomer(Customer customer) {
		Object response = null;
		this.restTemplate.put(this.host + this.updateCustomerURL, customer, response);
		return (Customer) response;

	}

	public void deleteCustomerById(int id) {
		this.restTemplate.delete(this.host + this.deleteCustomerURL + id);

	}

}
