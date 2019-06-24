package com.itheima.dao;

import com.itheima.po.User;

public interface UserDao {
	/*根据id查信息*/

	
	public User findUserByUsername(String username);
	
	public void addUser(User user);
}
