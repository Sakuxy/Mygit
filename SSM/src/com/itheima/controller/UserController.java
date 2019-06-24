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

	//�����û���¼�ı��ύ
		@RequestMapping(value = "/login.do")
		public String login(
				@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,ModelMap model) {
			if (!userService.isUserExist(username)) {
				model.addAttribute("msg", "�û��������ڣ�");
				
			} else {
				if (password.equals(userService.getPasswordByUsername(username))) {
					model.addAttribute("msg", "��¼�ɹ���");
					User user = userService.findUserByUsername(username);
					model.addAttribute("user", user);
					return "main";
				} else {
					model.addAttribute("msg", "�������");
					
				}
			}		
			
			return "login";	
		}
	 
		//�����û�ע��ı��ύ
		@RequestMapping(value = "/register.do")
		public String register(
				@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,
				@RequestParam(value="tel") String tel,
				@RequestParam(value="address") String address,ModelMap model) {
			if (!userService.isUserExist(username)) {
				model.addAttribute("msg", "�û����Ѵ��ڻ���Ч��");
			}
			else {
				userService.addUser(username, password,tel,address);
				model.addAttribute("msg", "ע��ɹ���");
				
			}
			return "register";
		}
}
