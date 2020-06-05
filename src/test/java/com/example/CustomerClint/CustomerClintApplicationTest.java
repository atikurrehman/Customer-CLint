package com.example.CustomerClint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CustomerClint.pojo.Customer;
import com.example.CustomerClint.rest_clint.Customer_REST_Clint;

@SpringBootTest

class CustomerClintApplicationTest {

	@Autowired
	Customer_REST_Clint clint;

	@Test
	void testGetCustomerById() {
		assertEquals(1, clint.getCustomerById(1).getId());
	}

	@Test
	void testSaveCustomer() {
		assertEquals(new Customer(2, "test"), clint.saveCustomer(new Customer(2, "test")));
	}

	@Test
	void testUpdateCustomer() {
		assertEquals(new Customer(3, "test2"), clint.saveCustomer(new Customer(3, "test2")));

	}

	@Test
	void testDeleteCustomerById() {
		clint.deleteCustomerById(0);
	}

}
