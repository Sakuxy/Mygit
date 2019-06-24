package com.itheima.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.po.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	//关于用户登录的表单提交
		@RequestMapping(value = "/login.do")
		public String login(
				@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,ModelMap model) {
			if (!userService.isUserExist(username)) {
				model.addAttribute("msg", "用户名不存在！");
				
			} else {
				if (password.equals(userService.getPasswordByUsername(username))) {
					model.addAttribute("msg", "登录成功！");
					User user = userService.findUserByUsername(username);
					model.addAttribute("user", user);
					return "main";
				} else {
					model.addAttribute("msg", "密码错误！");
					
				}
			}		
			
			return "login";	
		}
	 
		//关于用户注册的表单提交
		@RequestMapping(value = "/register.do")
		public String register(
				@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,
				@RequestParam(value="tel") String tel,
				@RequestParam(value="address") String address,ModelMap model) {
			if (!userService.isUserExist(username)) {
				model.addAttribute("msg", "用户名已存在或无效！");
			}
			else {
				userService.addUser(username, password,tel,address);
				model.addAttribute("msg", "注册成功！");
				
			}
			return "register";
		}
}
