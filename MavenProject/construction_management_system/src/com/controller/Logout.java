package com.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utils.Managesession;

@Controller
public class Logout {
	
	@RequestMapping("/logout") 
    public ModelAndView logout() throws Exception { 
		 
		 if(Managesession.checksession()) 
		 {
			 Managesession.getSession().invalidate();   
		        return new ModelAndView("index");  
		 }
		 return new ModelAndView("404");
		  
    }  
}
