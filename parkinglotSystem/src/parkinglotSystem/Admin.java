package parkinglotSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.JOptionPane;

public class Admin {
	private String name;
	private String pwd;
	private String dutyHrs;
	private String status;
	
	Admin(){
		pwd="abc123";
		dutyHrs="00:00-23:59";
		status="offDuty";
		name="abc";
	}
	
	Admin(String name,String pwd,String dutyHrs,String status){
		this.dutyHrs=dutyHrs;
		this.name=name;
		this.pwd=pwd;
		this.status=status;
	}
	
	public boolean login(String u,String p) {
		 try{
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
	            System.out.println("Connected Successfully");
	            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Admin WHERE AName='"+u+"'AND password='"+p+"'");
	            ResultSet resultSet=preparedStatement.executeQuery();
	            while(resultSet.next()){
	                 this.dutyHrs=resultSet.getString("dutyHrs");
	                 this.name=resultSet.getString("AName");
	                 this.pwd=resultSet.getString("password");
	                 this.status="onDuty";
	                 System.out.println("Login was successful!"+name);
	                 return true;
	            }	     
		     }
	         catch(Exception e){
	            System.out.println("Error in connection");
	         }
		 return false;
	}
	public void logout() {
		status="offDuty";
		 try{
			 int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout "+name+"?");
			 if(confirm==JOptionPane.YES_OPTION) {
				 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
				 Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
				 System.out.println("Connected Successfully");
				 PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Admin SET status=\"offDuty\" WHERE AName='"+this.name+"'");
				 int c=preparedStatement.executeUpdate();
				 if(c>0) {
					 JOptionPane.showMessageDialog(null, "Log out was successful","Success!",JOptionPane.INFORMATION_MESSAGE);
					 //new loginGUI();
				 }
			 }
			 else if(confirm==JOptionPane.NO_OPTION) {
				 //intentionally left blank
			 }
			 else {
				//intentionally left blank
			 }
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	public String searchVehicle(int index,Vehicle v) {
		String vtype=new String();//JOptionPane.showInputDialog("Enter vehicle type:");
		if(index==0) 
			vtype="car";
		else if(index==1)
			vtype="bike";
		else if(index==2)
			vtype="truck";
		else
			vtype="bus";
			StringBuilder str=new StringBuilder();//=JOptionPane.showInputDialog("Enter vehicle regno:");
			 try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
		            System.out.println("Connected Successfully");
		            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Vehicle WHERE vehicleType='"+vtype+"' and RegNo='"+v.getRegNo()+"' or OwnerName='"+v.getOwnerName()+"'or model='"+v.getModel()+"'or color='"+v.getColor()+"'");
		            ResultSet resultSet=preparedStatement.executeQuery();
		            while(resultSet.next()){
		                str.append(resultSet.getString("RegNo")).append("-").append(resultSet.getString("OwnerName")).append(resultSet.getString("model")).append(resultSet.getString("color"));
		                str.append("-").append(resultSet.getString("pNo")).append(resultSet.getString("fNo")).append("\n");
		            }

			     }
		         catch(Exception e1){
		            System.out.println("Error in connection");
		         }
			 return str.toString();
	}
	public String searchSlot(String vtype) {
		parkingLot p=new parkingLot();
		 try{
		  String name=JOptionPane.showInputDialog("Enter name of product to search");
		  
          Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
          Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
          System.out.println("Connected Successfully");
          PreparedStatement preparedStatement=connection.prepareStatement("select * from ParkingSlot where type=\""+vtype+"\"and status=0  FETCH FIRST 1 ROW ONLY");
          ResultSet resultSet=preparedStatement.executeQuery();
          while(resultSet.next()){
        	 
               String fno=resultSet.getString("fNo");
               int pno=resultSet.getInt("pNo");
               p=new parkingLot(pno,fno,vtype);
          }	     
	     }
          catch(Exception e){
          System.out.println("Error in connection or db query");
      }
		 
		return p.toString();
	}
	public void viewAll() {
		
	}
	public void parkVehicle() {
		
	}
	public double calculateBill() {
		String vtype=JOptionPane.showInputDialog("Enter vehicle type:");
		String reg=JOptionPane.showInputDialog("Enter Plate No:");
		double bill=0;
		Vehicle v=new Vehicle();
			StringBuilder str=new StringBuilder();//=JOptionPane.showInputDialog("Enter vehicle regno:");
			 try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://D:\\jp\\PLMS.accdb");//Establishing Connection
		            System.out.println("Connected Successfully");
		            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Vehicle WHERE vehicleType='"+vtype+"' and RegNo='"+reg+"'");
		            ResultSet resultSet=preparedStatement.executeQuery();
		            while(resultSet.next()){
		            	v.setEntryDate(resultSet.getString("entryDate"));
		            	v.setEntryTime(resultSet.getString("entryTime"));
		            	v.setRegNo(resultSet.getString("RegNo"));
		            	//v.setfNo(resultSet.getString("entryDate"));
		            	//v.setEntryDate(resultSet.getString("entryDate"));
		                str.append(resultSet.getString("RegNo")).append("-").append(resultSet.getString("OwnerName")).append(resultSet.getString("model")).append(resultSet.getString("color"));
		                str.append("-").append(resultSet.getString("pNo")).append(resultSet.getString("fNo")).append("\n");
		                str.append(resultSet.getString("entryDate")).append("\n").append(resultSet.getString("entryTime")).append("\n");
		                double timespent=calculateTime(resultSet.getString("entryDate"),resultSet.getString("entryTime"));
			            bill=timespent;
			            if(vtype.equals("bike"))
			            	bill=timespent/2;
			            else if(vtype.equals("bus")||vtype.equals("truck"))
			            	bill=timespent*2;
			            System.out.print(bill);
		                PreparedStatement preparedStatement2=connection.prepareStatement("update ParkingSlot set status=0 where pNo='"+resultSet.getString("pNo")+"'and fNo='"+resultSet.getString("fNo")+"'");
			            int c=preparedStatement2.executeUpdate();
			           
			            PreparedStatement preparedStatement3=connection.prepareStatement("DELETE FROM Vehicle where RegNo='"+v.getRegNo()+"'");
			            int c1=preparedStatement3.executeUpdate();
			            if(c1>0) {
			            	System.out.print("successfully vehicle record deleted");
			            	
			            }
			            if(c>0) {
			            	System.out.print("successfully parking lot freed");
			            }
		            }
		          
			     }
		         catch(Exception e1){
		            System.out.println("Error in connection");
		            e1.printStackTrace();
		         }
			 return bill;
	}
	   public double calculateTime(String entryDate, String entryTime) {
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate date1 = parseDate(entryDate);
	        LocalTime time1 = LocalTime.parse(entryTime, DateTimeFormatter.ofPattern("HH:mm"));
	        LocalDateTime entryDateTime = LocalDateTime.of(date1, time1);
	        LocalDateTime exitDateTime = LocalDateTime.now(); // Assuming current date/time

	        // Calculate time difference in hours
	        long hoursDifference = ChronoUnit.HOURS.between(entryDateTime, exitDateTime);
	        long minutesDifference = ChronoUnit.MINUTES.between(entryDateTime, exitDateTime);

	        double timeSpent = hoursDifference + (double) minutesDifference / 60;
	        System.out.print(timeSpent);
	        return timeSpent;
	    }

	  private LocalDate parseDate(String dateString) {
	        String[] parts = dateString.split("/");
	        int month = Integer.parseInt(parts[0]);
	        int day = Integer.parseInt(parts[1]);
	        int year = Integer.parseInt(parts[2]);
	        return LocalDate.of(year, month, day);
	    }

	
	
//-----------------setters and getters--------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDutyHrs() {
		return dutyHrs;
	}
	public void setDutyHrs(String dutyHrs) {
		this.dutyHrs = dutyHrs;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
