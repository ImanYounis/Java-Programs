package parkingLot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ParkingSlot {
	public void changeParkingSlotStatus(String parkingAddress) {
		String parking[] = parkingAddress.split("--");
		int pNo = Integer.parseInt(parking[0]);

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection
					.prepareStatement("Update ParkingSlot set status=? Where pNo=?");
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, pNo);
			int result = preparedStatement.executeUpdate();
			System.out.println("Executed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in connection");

		}
	}

}
