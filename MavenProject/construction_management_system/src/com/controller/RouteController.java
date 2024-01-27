package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.bean.Contractorbean;
import com.utils.Managesession;
import com.utils.Verifysession;

@Controller

public class RouteController {
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;

	@RequestMapping("/admin")
	public ModelAndView admin() {

		return new ModelAndView("admin");
	}

	@RequestMapping("/registration")
	public ModelAndView register() {
		
		return new ModelAndView("registration");
		

	}

	@RequestMapping("/vieweamp")
	public ModelAndView regisdfter() {

		return new ModelAndView("visewemp");
	}

	@RequestMapping("/uploadpage")
	public ModelAndView raaegister() {

		return new ModelAndView("uploadpage");
	}

	@RequestMapping("/redirectthis")
	public ModelAndView regisaster() {

		return new ModelAndView("redirect:project.html");
	}

	@RequestMapping("/index")
	public ModelAndView rghr() {

		return new ModelAndView("index");
	}

	@RequestMapping("/dashboard")
	public ModelAndView dash() throws Exception {

		if (Managesession.checksession()) {
			return new ModelAndView("dashboard");
		} else {
			return new ModelAndView("index");
		}

	}

	@RequestMapping("/addproject")
	public ModelAndView addproject() throws Exception {
		if (Managesession.checksession()) {
			return new ModelAndView("addproject");
		} else {
			return new ModelAndView("index");
		}

	}

	@RequestMapping("/newtest")
	public ModelAndView addemplsoye() throws Exception {
		if (Managesession.checksession()) {
			return new ModelAndView("newtest");
		} else {
			return new ModelAndView("index");
		}

	}

	@RequestMapping("/newemployee")
	public ModelAndView addemploye() throws Exception {
		if (Managesession.checksession()) {
			return new ModelAndView("addemployee");
		} else {
			return new ModelAndView("index");
		}

	}
}
