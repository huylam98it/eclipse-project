package com.huylam98it.webuploadfile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huylam98it.webuploadfile.model.Customer;

@Repository("customerDao")
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.cusUsername = :username")
	public Customer getByUsername(@Param("username") String username);
}
