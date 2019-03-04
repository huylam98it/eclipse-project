package com.huylam98it.restful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huylam98it.restful.dao.CustomerDao;
import com.huylam98it.restful.model.Customer;

@Service("customerService")
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void add(Customer c) {
		customerDao.save(c);
	}

	public void update(Customer c) throws Exception {
		Optional<Customer> op = customerDao.findById(c.getId());
		if (!op.isPresent()) {
			throw new Exception();
		}
		customerDao.save(c);
	}

	public void delete(Customer c) {
		customerDao.delete(c);
	}

	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	public Customer find(int id) {
		Optional<Customer> c = customerDao.findById(id);
		if (c.isPresent()) {
			return c.get();
		} else
			return null;
	}
}
