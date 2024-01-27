package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Projectfetchbean;
import com.bean.Taskbean;
import com.utils.Dbcon;
import com.utils.Managesession;

@Controller
public class TaskController {
	@RequestMapping("/addtask")
	public ModelAndView regisster(@RequestParam("pid") String pid,@RequestParam("pname") String pname) {
		Map map = new HashMap();
		map.put("pid",pid);
		map.put("pname", pname);
		return new ModelAndView("addtask","list",map);
	}
	@RequestMapping(value = "/inserttask", method = RequestMethod.GET) 
	public ModelAndView helloWorld(@ModelAttribute("add") Projectfetchbean add ) {  
		  
		 try {
			if(Managesession.checksession()) 
			 {
				
				Connection con =Dbcon.getConnection();
				PreparedStatement pre;
				System.out.println(add.getTaskdesc());
				System.out.println(add.getPid());
				try {
					pre = con.prepareStatement("insert into task (tname , progress , pid) values ( ? , ? , ? ) ");
					pre.setString(1, add.getTaskdesc());
					pre.setString(2, "N");
					pre.setString(3, add.getPid());
					int i=pre.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String message = "<script type=\"text/javascript\">swal(\"Good job!\", \"Task added Successfully!\", \"success\")</script>";
				Map map = new HashMap();
				map.put("pid",add.getPid());
				map.put("pname", add.getPname());
				map.put("message", message);
				return new ModelAndView("addtask","list",map);
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
	
	@RequestMapping(value = "/deletetask", method = RequestMethod.GET) 
    public ModelAndView Delete(@RequestParam("tid") String tid,@RequestParam("pid") String pid) {  
		Connection con =Dbcon.getConnection();
		PreparedStatement pre;
		try {
			pre = con.prepareStatement("delete from task where tid = ? ");
			pre.setString(1, tid);
			pre.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("redirect:showmoreproject.html?pid="+pid);  
    } 
	
	
	@RequestMapping(value = "/taskcomp", method = RequestMethod.GET) 
    public ModelAndView complet(@ModelAttribute("task") Taskbean task, @RequestParam("tid") String tid,@RequestParam("pid") String pid) {  
		Connection con =Dbcon.getConnection();
		PreparedStatement pre;
		try {
			pre = con.prepareStatement("update task set progress = ? where tid = ? ");
			pre.setString(1, "Y");
			pre.setString(2, task.getTid());
			pre.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("redirect:showmoreproject.html?pid="+pid);  
    } 
}
