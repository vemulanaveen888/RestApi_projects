/*package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired  
    UserDao dao;//will inject dao from xml file  
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") UserBean user) {
		
		dao.saveUser(user);
		return new ModelAndView("viewemp","user", user);// will redirect to viewemp
	
		// request mapping
		
	}
}
*/