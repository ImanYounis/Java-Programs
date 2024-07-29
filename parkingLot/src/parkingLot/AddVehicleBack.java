package parkingLot;

import java.sql.Connection;
import java.util.Date;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddVehicleBack {
	public void databaseSubmit(String regNO, String name, String model, String color, String type, String pNo) {
		String separate[] = pNo.split("--");
		pNo = separate[0];
		String fNo = separate[1];
		Date date = new Date();
		LocalDate d1 = LocalDate.now();
		LocalTime t1 = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
		String doe = d1.format(formatter);
		String ct = formatTime.format(date);
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM Vehicle WHERE RegNo='" + regNO+"'");
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				JOptionPane.showMessageDialog(null,"The vehicle already exists in the parking space", "Can't add vehicle",JOptionPane.ERROR_MESSAGE);
				return;
			}
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into Vehicle (OwnerName,vehicleType,model,color,pNo,fNo,entryDate,entryTime,RegNo) values (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, type);
			preparedStatement.setString(3, model);
			preparedStatement.setString(4, color);
			preparedStatement.setString(5, pNo);
			preparedStatement.setString(6, fNo);
			preparedStatement.setString(7, doe);
			preparedStatement.setString(8, ct);
			preparedStatement.setString(9, regNO);
			int result = preparedStatement.executeUpdate();
			if (result > 0)
				System.out.println("Inserted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
	}

	public ResultSet getFreeParkingSlots(String type) {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select pNo, fNo from ParkingSlot where status=? and Lower(type)=?");
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, type);
			result = preparedStatement.executeQuery();
			System.out.println("Executed Successfully");
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
		return result;
	}

}
