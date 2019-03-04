package com.huylam98it.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylam98it.springsecurity.model.Role;

@Repository("roleDao")
public interface RoleDao extends JpaRepository<Role, Integer> {

}
