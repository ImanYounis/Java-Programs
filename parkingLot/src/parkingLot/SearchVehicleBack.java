package parkingLot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchVehicleBack {
	public ResultSet searchreg(String plateno) {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from Vehicle where RegNo=?");
			preparedStatement.setString(1, plateno);
			result = preparedStatement.executeQuery();
		} catch (Exception e) {
			System.out.println("Error in Connection");

		}
		return result;
	}

	public ResultSet searchtype(String type) {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select * from Vehicle where LOWER(vehicleType)=?");
			preparedStatement.setString(1, type);
			result = preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	public ResultSet searchname(String ownername) {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select * from Vehicle where LOWER(OwnerName)=?");
			preparedStatement.setString(1, ownername);
			result = preparedStatement.executeQuery();
		} catch (Exception e) {
			System.out.println("Error in Connection");

		}
		return result;
	}

	public ResultSet searchmodel(String model) {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select * from Vehicle where LOWER(model)=?");
			preparedStatement.setString(1, model);
			result = preparedStatement.executeQuery();
		} catch (Exception e) {
			System.out.println("Error in Connection");

		}
		return result;
	}
}
