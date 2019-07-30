package com.samsolutions.myapp;

public class UserTest {

	private String login;
	private String password;

	public UserTest(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public UserTest() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

