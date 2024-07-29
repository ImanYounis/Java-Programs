package parkingLot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;

public class AdminBack {
	private String name;
	private String pwd;
	private String dutyHrs;
	private String status;

	AdminBack() {
		name="iman";
		status="offDuty";
		pwd="iman2003";
		dutyHrs="6:00-12:00";
	}
	AdminBack(AdminBack a){
		this.dutyHrs=a.dutyHrs;
		this.name=a.name;
		this.pwd=a.pwd;
		this.status=a.status;
	}
	AdminBack(String name, String pwd, String dutyHrs, String status) {
		this.dutyHrs = dutyHrs;
		this.name = name;
		this.pwd = pwd;
		this.status = status;
	}

	public boolean login(String u, String p) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Admin WHERE AName='" + u + "'AND password='" + p + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				this.dutyHrs = resultSet.getString("dutyHrs");
				this.name = resultSet.getString("AName");
				this.pwd = resultSet.getString("password");
				this.status = "onDuty";
				PreparedStatement ps = connection
						.prepareStatement("UPDATE Admin SET status=\"onDuty\" WHERE AName='"+u+"'");
				int c=ps.executeUpdate();
				if(c>0)
				System.out.println("Login was successful!" + name);
				Login.setLoggedIn(true);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error in connection");
		}
		return false;
	}

	public void logout() {
		status = "offDuty";
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
			if (confirm == 0) {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
				Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																														// Connection
				System.out.println("Connected Successfully");
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE Admin SET status=\"offDuty\" WHERE AName='" + this.name + "'");
				int c = preparedStatement.executeUpdate();
				if (c > 0) {
					JOptionPane.showMessageDialog(null, "Log out was successful", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
					// new loginGUI();
					Login.setLoggedIn(false);
				}
			} else if (confirm == 1||confirm ==2) {
				Login.setLoggedIn(true);
				new AdminFront();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
