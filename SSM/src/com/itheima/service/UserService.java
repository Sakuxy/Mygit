package com.itheima.service;

import com.itheima.po.User;
public interface UserService {
	public User findUserByUsername(String username);
	public boolean isUserExist(String username);
	public void addUser(String username,String password,String tel,String address);
	public String getPasswordByUsername(String username);
	
}
