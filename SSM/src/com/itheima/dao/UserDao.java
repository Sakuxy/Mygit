package com.itheima.dao;

import com.itheima.po.User;

public interface UserDao {
	/*����id����Ϣ*/

	
	public User findUserByUsername(String username);
	
	public void addUser(User user);
}
