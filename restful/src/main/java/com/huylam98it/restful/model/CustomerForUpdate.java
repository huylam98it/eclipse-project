package com.huylam98it.restful.model;

public class CustomerForUpdate {
	private String fullname;

	private String password;

	private String username;

	public CustomerForUpdate() {
		super();
	}

	public CustomerForUpdate(String fullname, String password, String username) {
		super();
		this.fullname = fullname;
		this.password = password;
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
