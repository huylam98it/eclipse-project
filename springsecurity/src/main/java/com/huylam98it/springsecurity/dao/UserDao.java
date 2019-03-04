package com.huylam98it.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huylam98it.springsecurity.model.User;

@Repository("userDao")
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.username =:us")
	public User findByUsername(@Param("us") String username);
}
