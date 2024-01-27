/*package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UserBean;

public class UserDao extends ApplicationDao{

	private static final String INSERT_USER=" insert into user_details(user_name,email,password,create_date,updated_date) values(?,?,?,?,?)";
	public boolean saveUser(final UserBean user){  
	      
		try {
			System.out.println(this.jdbcTemplate.getDataSource().getConnection());
			Connection con = this.jdbcTemplate.getDataSource().getConnection();
			PreparedStatement pre = con.prepareStatement(INSERT_USER);
			pre.setString(1,user.getName());  
			pre.setString(2,user.getEmail());
			pre.setString(3,user.getPassword()); 
			pre.setTimestamp(4,new java.sql.Timestamp(user.getCreatedDate().getTime()));  
			pre.setTimestamp(5,new java.sql.Timestamp(user.getUpdatedDate().getTime()));  
			pre.executeUpdate();        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	    
	}    
}
*/