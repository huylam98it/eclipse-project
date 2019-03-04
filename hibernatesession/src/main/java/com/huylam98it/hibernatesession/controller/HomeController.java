package com.huylam98it.hibernatesession.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.huylam98it.hibernatesession.model.User;

@Controller
@Transactional
public class HomeController {

	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping(value = "/")
	public String home() {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from User", User.class).getResultList();
		for (User u : users) {
			System.out.println(u.getUsername());
		}
		return "home";
	}
}
