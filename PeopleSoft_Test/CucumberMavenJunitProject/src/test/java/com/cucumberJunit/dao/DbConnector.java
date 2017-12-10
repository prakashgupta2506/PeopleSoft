package com.cucumberJunit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DbConnector {
	private static final Logger logger=Logger.getLogger(DbConnector.class);
	private static DbConnector db=null;
	 private static  Connection connection=null;
	   private static Statement statement=null;
	   private static ResultSet rs=null;
	   
	private DbConnector(){
		 try {
	        	
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  
	        	  
	        	//step2 create  the connection object  
	        	connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");  
	        	  
	           
	        	logger.debug("Connecting to Database...");
	           
	            if (connection != null) {
	            	logger.debug("Connected to the Database...");
	            }
	        } catch (SQLException ex) {
	           ex.printStackTrace();
	           logger.debug("print message "+ex.getMessage());
	        }
	        catch (ClassNotFoundException ex) {
	           ex.printStackTrace();
	           logger.debug("print message "+ex.getMessage());
	        }
		}
		
	
	public static DbConnector getDbIntance(){
		logger.debug("inside getDbInstance method");
		if(db==null){
			db=new DbConnector();
		}
		return db;
		
	}

	
	public static ResultSet dbConnection(String query){
		logger.debug("inside dbConnection");
		try{
		statement = connection.createStatement();
        rs = statement.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
			 logger.debug("print message "+e.getMessage());
		}
		return rs;
	}
	
	
	public static void closeDBConnection(){
		try{
			if (connection != null){
				connection.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			 logger.debug("print message "+e.getMessage());
		}
	}
}