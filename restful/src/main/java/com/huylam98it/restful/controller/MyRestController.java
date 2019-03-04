package com.huylam98it.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huylam98it.restful.model.Customer;
import com.huylam98it.restful.model.Message;
import com.huylam98it.restful.service.CustomerService;

@RestController
@RequestMapping(value = "/api")
public class MyRestController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/getall")
	public ResponseEntity<List<Customer>> getAll() {
		return new ResponseEntity<List<Customer>>(customerService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Object> find(@PathVariable("id") int id) {
		Customer c = customerService.find(id);
		if (c != null) {
			Message m = new Message("got", c);
			return new ResponseEntity<Object>(m, HttpStatus.OK);
		} else {
			Message m = new Message("err", c);
			return new ResponseEntity<Object>(m, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/update")
	public ResponseEntity<Object> update(@RequestBody Customer c) {
		try {
			customerService.update(c);
			Message m = new Message("updated", c);
			return new ResponseEntity<Object>(m, HttpStatus.OK);
		} catch (Exception e) {
			Message m = new Message("customer not found", c);
			return new ResponseEntity<Object>(m, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> add(@RequestBody Customer c) {
		try {
			customerService.add(c);
			Message m = new Message("added", c);
			return new ResponseEntity<Object>(m, HttpStatus.OK);
		} catch (Exception e) {
			Message m = new Message("cound't add", c);
			return new ResponseEntity<Object>(m, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Object> add(@PathVariable("id") int id) {
		try {
			Customer c = new Customer();
			c.setId(id);
			customerService.delete(c);
			Message m = new Message("deleted", null);
			return new ResponseEntity<Object>(m, HttpStatus.OK);
		} catch (Exception e) {
			Message m = new Message("can't delete", null);
			return new ResponseEntity<Object>(m, HttpStatus.BAD_REQUEST);
		}
	}
}
