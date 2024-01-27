package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;

import com.utils.Dbcon;
import com.utils.Managesession;
@Controller
@SessionAttributes("user")
public class Indexcontroller {
	
	 @RequestMapping(value = "/verifylogin", method = RequestMethod.POST)
		public ModelAndView save(@ModelAttribute("select") Login select,HttpSession session ) {
			
		// TODO Auto-generated method stub
				try {
					
					if((select.getEmail().equals("admin@kjc.com"))&&(select.getPassword().equals("admin"))) {
						 
						String user="ADMIN";
						Managesession.setSession(session);
						 Managesession.getSession().setAttribute("user", user);
						 Managesession.getSession().setAttribute("username", "Admin");
						return new ModelAndView("admin","user", user);
					}
					else {
					Connection con = Dbcon.getConnection();
					PreparedStatement pre =  con.prepareStatement("select * from contractor_reg where email= ? ");
					
					pre.setString(1, select.getEmail());
					ResultSet rs= pre.executeQuery();
					if(rs.next()) {
						
						 if((rs.getString("email").equals(select.getEmail()))&&(rs.getString("password").equals(select.getPassword()))) {
							String user = rs.getString("conid");
							String username = rs.getString("username");
							 Managesession.setSession(session);
							 Managesession.getSession().setAttribute("user", user);
							 Managesession.getSession().setAttribute("username", username);
							return new ModelAndView("dashboard","user", user);
						}
						
					}
					
					
					
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String message ="<script type=\"text/javascript\">swal ( \"Oops\" ,  \"email or Password doesnt match!\" ,  \"error\" )</script>";
				return new ModelAndView("index","message", message);
		}

}
