package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Contractorbean;
import com.bean.Employeebean;
import com.bean.Materialbean;
import com.bean.Projectfetchbean;
import com.bean.Taskbean;
import com.utils.ApiTest;
import com.utils.Dbcon;
import com.utils.Managesession;


@Controller
public class AdminController {


	
	
	
	@RequestMapping("/projectreport")
	public ModelAndView helloWorld() {  
		  
		 try {
			if(Managesession.checksession()) 
			 {
				List<Projectfetchbean> listOfproject =  new ArrayList<>();
				Connection con =Dbcon.getConnection();
				PreparedStatement pre;
				try {
					pre = con.prepareStatement("select * from project ");
					ResultSet rs= pre.executeQuery();
					while(rs.next()){
						Projectfetchbean proj = new Projectfetchbean();
						proj.setPname(rs.getString("pname"));
						proj.setBalance(rs.getString("balance"));
						proj.setBudget(rs.getString("budget"));
						proj.setCust_addr(rs.getString("cust_addr"));
						proj.setCust_mob(rs.getString("cust_mob"));
						proj.setStart(rs.getString("sdate"));
						proj.setEnd(rs.getString("edate"));
						proj.setCust_name(rs.getString("customer_name"));
						proj.setConid(rs.getString("conid"));
						proj.setPid(rs.getString("pid"));
						listOfproject.add(proj);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		        return new ModelAndView("projectreport","list",listOfproject); 
			 }
			 else 
			 {
			   return new ModelAndView("index"); 
			 }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 return new ModelAndView("404"); 
   }  
	
	
	 @RequestMapping("/employeereport")   
	 public ModelAndView hello() {  
		  
		 try {
			if(Managesession.checksession()) 
			 {
				List<Employeebean> listofemployee =  new ArrayList<>();
				Connection con =Dbcon.getConnection();
				PreparedStatement pre;
				try {
					pre = con.prepareStatement("select * from employee ");
					ResultSet rs= pre.executeQuery();
					while(rs.next()){
						Employeebean eb = new Employeebean();
						eb.setEmpid(rs.getString("empid")); 
						eb.setEmp_name(rs.getString("emp_name"));
						eb.setAddress(rs.getString("address"));
						eb.setDob(rs.getString("dob"));
						eb.setPhone(rs.getString("phone"));
						
						listofemployee.add(eb);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return new ModelAndView("employeereport","list",listofemployee); 
			 }
			 else 
			 {
			   return new ModelAndView("index"); 
			 }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 return new ModelAndView("404"); 
    }  

	 @RequestMapping("/contractorsreport")   
	 public ModelAndView hellos() {  
		  
		 try {
			if(Managesession.checksession()) 
			 {
				List<Contractorbean> listofuser =  new ArrayList<>();
				Connection con =Dbcon.getConnection();
				PreparedStatement pre;
				try {
					pre = con.prepareStatement("select * from contractor_reg ");
					ResultSet rs= pre.executeQuery();
					while(rs.next()){
						Contractorbean eb = new Contractorbean();
						eb.setConid(rs.getString("conid")); 
						eb.setFullname(rs.getString("fullname"));
						eb.setEmail(rs.getString("email"));
						eb.setUsername(rs.getString("username"));
						eb.setMobile(rs.getString("mobile"));
						
						listofuser.add(eb);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return new ModelAndView("contractorsreport","list",listofuser); 
			 }
			 else 
			 {
			   return new ModelAndView("index"); 
			 }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 return new ModelAndView("404"); 
    }  

	
}
