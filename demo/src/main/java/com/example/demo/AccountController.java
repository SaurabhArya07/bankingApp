package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {
	@Autowired
	CustomerService customerService;
	ArrayList<Customer> customers = new ArrayList<>();
	@GetMapping("/")
	List<Customer> getUsers(){
		return customerService.getUsers();
	}
	
	@GetMapping("/{id}")
	Customer getUserDetail(@PathVariable String AcntNumber) {
		for(Customer cus: customers) {
			if(cus.getAccountNumber().equals(AcntNumber)) {
				return cus;
			}
		}
		return null;
	}
	
	@PostMapping()
	String addEntry(@RequestBody Customer customer) {
		customerService.save(customer);
		return "Account added successfully!!";
	}
	
	
}