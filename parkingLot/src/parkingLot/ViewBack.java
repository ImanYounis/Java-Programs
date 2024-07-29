package parkingLot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBack {
	public ResultSet getParkingSlotsf1() {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");
																													
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from ParkingSlot where fNo=?");
			preparedStatement.setString(1, "B1");
			result = preparedStatement.executeQuery();
			System.out.println("Executed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
		return result;
	}

	public ResultSet getParkingSlotsf2() {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");
																													
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from ParkingSlot where fNo=?");
			preparedStatement.setString(1, "B2");
			result = preparedStatement.executeQuery();
			System.out.println("Executed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
		return result;
	}

	public ResultSet getParkingSlotsf3() {
		ResultSet result = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");
																													
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from ParkingSlot where fNo=?");
			preparedStatement.setString(1, "B3");
			result = preparedStatement.executeQuery();
			System.out.println("Executed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
		return result;
	}
}
