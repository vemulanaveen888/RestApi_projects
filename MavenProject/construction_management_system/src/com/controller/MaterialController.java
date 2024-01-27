package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Materialbean;
import com.bean.Projectfetchbean;
import com.utils.Dbcon;
import com.utils.Managesession;

@Controller
public class MaterialController {

	@RequestMapping("/addmaterial")
	public ModelAndView regisster(@RequestParam("pid") String pid,@RequestParam("pname") String pname) {
		Map map = new HashMap();
		map.put("pid",pid);
		map.put("pname", pname);
		return new ModelAndView("addmaterial","list",map);
	}
	@RequestMapping(value = "/insertmaterial", method = RequestMethod.GET) 
	public ModelAndView helloWorld(@ModelAttribute("add") Projectfetchbean add ,@ModelAttribute("mb") Materialbean mb ) {  
		  
		 try {
			if(Managesession.checksession()) 
			 {
				int total=Integer.parseInt(mb.getUnit())*Integer.parseInt(mb.getRate());
				Connection con =Dbcon.getConnection();
				PreparedStatement pre;
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				   LocalDateTime now = LocalDateTime.now();  
				String date=dtf.format(now);
				try {
				
					
					
					//change balance
					int balance;
					pre = con.prepareStatement("select balance from project where pid=? ");
					pre.setString(1, add.getPid());
					ResultSet rs= pre.executeQuery();
					while(rs.next()){
						balance=Integer.parseInt(rs.getString("balance"));
						if((balance-total)<0) {
							String message ="<script type=\"text/javascript\">swal ( \"Oops\" ,  \"low balance to add materials!\" ,  \"error\" )</script>";
							Map map = new HashMap();
							map.put("pid",add.getPid());
							map.put("pname",add.getPname() );
							map.put("message",message );
							return new ModelAndView("addmaterial", "list",map);
							
						}
						balance=balance-total;
						pre = con.prepareStatement("update project set balance=? where pid=?");
						pre.setString(1, String.valueOf(balance));
						pre.setString(2, add.getPid());
						int ii=pre.executeUpdate();
					}
					
					pre = con.prepareStatement("insert into materials (mname , mdesc , unit , rate , pid , dop , total) values ( ? , ? , ? , ? , ? , ? , ? ) ");
					pre.setString(1, mb.getMname());
					pre.setString(2, mb.getMdesc());
					pre.setString(3, mb.getUnit());
					pre.setString(4, mb.getRate());
					pre.setString(5, add.getPid());
					pre.setString(6, date);
					pre.setString(7, String.valueOf(total));
					System.out.println(String.valueOf(total));
					int i=pre.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String message = "<script type=\"text/javascript\">swal(\"Good job!\", \"Material added Successfully!\", \"success\")</script>";
				Map map = new HashMap();
				map.put("pid",add.getPid());
				map.put("pname",add.getPname() );
				map.put("message",message );
				return new ModelAndView("addmaterial","list",map);
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
