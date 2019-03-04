package com.huylam98it.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylam98it.restful.model.Customer;

@Repository("customerDao")
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
