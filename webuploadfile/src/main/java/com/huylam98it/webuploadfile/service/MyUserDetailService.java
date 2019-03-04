package com.huylam98it.webuploadfile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huylam98it.webuploadfile.dao.CustomerDao;
import com.huylam98it.webuploadfile.model.Customer;

@Service("myUserDetailsService")
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerDao.getByUsername(username);
		if (customer == null) {
			throw new UsernameNotFoundException("khong tim thay user");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(customer.getRoleBean().getRoleName().toString()));
		User u = new User(username, customer.getCusPassword(), authorities);
		return u;
	}
}
