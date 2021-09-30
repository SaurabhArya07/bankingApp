package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	public void save(Customer cus) {
		repository.save(cus);
		System.out.println(cus);
	}
	public java.util.List<Customer> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}	

}
