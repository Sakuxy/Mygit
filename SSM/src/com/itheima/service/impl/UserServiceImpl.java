package com.itheima.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itheima.dao.UserDao;
import com.itheima.po.User;
import com.itheima.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	//注解注入UserDao
	@Autowired
	private UserDao userDao;
	//查询user

	public User findUserByUsername(String username) {
		return this.userDao.findUserByUsername(username);
	}
	//判断用户是否存在
	public boolean isUserExist(String username) {
		if(userDao.findUserByUsername(username) == null) {
			return false;
		} else {
			return true;
		}
	}
	//根据提供的用户名拿密码
		public String getPasswordByUsername(String username) {
			return userDao.findUserByUsername(username).getPassword();
		}
	//新增一个用户
	public void addUser(String username,String password,String tel,String address) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setTel(tel);
			user.setAddress(address);
			userDao.addUser(user);
	}
}
