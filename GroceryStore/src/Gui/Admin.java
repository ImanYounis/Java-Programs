package Gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Admin {
	private String username;
	private String pwd;
	private String email;
	//--------------------admin functions----------------------
	public boolean login(String u,String p) {
		 try{
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Admin WHERE AName='"+u+"'AND password='"+p+"'");
	            ResultSet resultSet=preparedStatement.executeQuery();
	            while(resultSet.next()){
	                 this.username=resultSet.getString("AName");
	                 this.pwd=resultSet.getString("password");
	                 System.out.println("Login was successful!"+username);
	                 return true;
	            }	     
		     }
	         catch(Exception e){
	            System.out.println("Error in connection or db query");
	            e.printStackTrace();
	         }
		 return false;
	}
	public boolean checkIfExists(String u,String p) {
		 try{
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Admin WHERE AName='"+u+"'AND password='"+p+"'");
	            ResultSet resultSet=preparedStatement.executeQuery();
	            while(resultSet.next()){
	                 return true;
	            }	     
		     }
	         catch(Exception e){
	            System.out.println("Error in connection or db query");
	            e.printStackTrace();
	         }
		 return false;
	}
	public boolean signup(String u,String p,String e) {
		if(!checkIfExists(u,p)) {
		
		 try{
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Admin (AName,password,status)VALUES ('"+u+"','"+p+"','"+e+"')");
	            int c=preparedStatement.executeUpdate();
	            if(c>0) {
	                 System.out.println("SignUp was successful!"+u);
	                 return true;
	            }	
	            else {
	            	System.out.println("SignUp failed");
	            }
		     }
	         catch(Exception e1){
	            System.out.println("Error in connection or db query");
	            e1.printStackTrace();
	         }
		 return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "User already exists. Please login","SignUp failed",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	public boolean addProduct(String n,int p,String d) {
		
		 try{
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Product (PName,Price,Description)VALUES ('"+n+"',"+p+",'"+d+"')");
	            int c=preparedStatement.executeUpdate();
	            if(c>0) {
	                 System.out.println("Product added successfully"+n);
	                 return true;
	            }	
	            else {
	            	System.out.println("Product add failed");
	            }
		     }
	         catch(Exception e1){
	            System.out.println("Error in connection or db query");
	            e1.printStackTrace();
	         }
		 return false;
	}
	
	//------------------constructors-------------------
	Admin(){
	
	}
	
	Admin(String name,String pwd){
		this.setUsername(name);
		this.setPwd(pwd);

	}
//---------------------setters and getters-----------------------
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
