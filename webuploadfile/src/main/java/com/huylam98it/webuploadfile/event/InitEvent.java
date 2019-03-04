package com.huylam98it.webuploadfile.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.huylam98it.webuploadfile.dao.CustomerDao;
import com.huylam98it.webuploadfile.dao.RoleDao;
import com.huylam98it.webuploadfile.model.Customer;

@Component
public class InitEvent implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	RoleDao roleDao;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Customer admin = customerDao.getByUsername("huylam98it");
		if (admin == null) {
			admin = new Customer();
			admin.setCusFullname("Pham Huy Lam");
			admin.setCusUsername("huylam98it");
			admin.setRoleBean(roleDao.findById(1).get());
			admin.setCusPassword(passwordEncoder.encode("Huylam98@"));
			customerDao.save(admin);
		}
	}

}
