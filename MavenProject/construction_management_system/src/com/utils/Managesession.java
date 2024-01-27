package com.utils;

import javax.servlet.http.HttpSession;

public class Managesession {
	static HttpSession session;
	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		Managesession.session = session;
	}
	public static boolean checksession() throws Exception {
		 try {

		 if(Managesession.getSession().getAttribute("user")!=null) {
			
			 return true;
		 }
		 else
			 return false;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return false;
	}

}
