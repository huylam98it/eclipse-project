package com.huylam98it.springsecurity.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.huylam98it.springsecurity.dao.UserDao;
import com.huylam98it.springsecurity.model.Role;
import com.huylam98it.springsecurity.model.User;

@Service("myUserDetailsService")
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("khong tim thay thong tin user");
		}
		System.out.println(user.getPassword());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		Role role = user.getRole();

		System.out.println(passwordEncoder.encode("huylam98it"));

		grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		org.springframework.security.core.userdetails.User u = new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), grantedAuthorities);
		System.out.println(u.getAuthorities());
		System.out.println(u.getPassword());
		return u;
	}

}
