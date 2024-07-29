package parkingLot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.JOptionPane;

public class BillBack {
	public String[] calculateBill() {
		String[] results = new String[5];
		String vtype = "";
		String reg = "";
		try {
			while (!vtype.matches("^(bike|car|truck|bus)$")) {
				vtype = JOptionPane.showInputDialog("Enter vehicle type (bike, car, truck, bus):");
//			if (!vtype.matches("^(bike|car|truck|bus)$")) {
//				JOptionPane.showMessageDialog(null, "Invalid vehicle type! Please enter bike, car, truck, or bus.",
//						"Invalid Input", JOptionPane.ERROR_MESSAGE);
//			}
				if (vtype == null || !vtype.toLowerCase().matches("^(bike|car|truck|bus)$")) {
					if (vtype == null) {
						// JOptionPane.showMessageDialog(null, "Input canceled!", "Canceled Input",
						// JOptionPane.WARNING_MESSAGE);
						System.out.println("cancelled");
						return results;
					} else {
						JOptionPane.showMessageDialog(null,
								"Invalid vehicle type! Please enter bike, car, truck, or bus.", "Invalid Input",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			// Validating registration number

			while (!reg.matches("^[A-Z]{3}-\\d{4}$")) {
				reg = JOptionPane.showInputDialog("Enter Plate No. (Format: XXX-####):");
				if (!reg.matches("^[A-Z]{3}-\\d{4}$")) {
					JOptionPane.showMessageDialog(null, "Invalid format! Format is: XXX-####", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NullPointerException e) {
			System.out.print("cancelled");
		}
		double bill = 0;

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM Vehicle WHERE vehicleType='" + vtype + "' and RegNo='" + reg + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				JOptionPane.showMessageDialog(null, "No such vehicle present", "Vehicle not Found",
						JOptionPane.ERROR_MESSAGE);
				return results;
			} else {
				do {
					results[0] = resultSet.getString("RegNo");
					results[1] = resultSet.getString("OwnerName");
					results[2] = resultSet.getString("entryDate");
					results[3] = resultSet.getString("entryTime");

					double timespent = calculateTime(resultSet.getString("entryDate"),
							resultSet.getString("entryTime"));
					bill = timespent * 50;
					if (vtype.equals("bike"))
						bill = timespent * 20;
					else if (vtype.equals("bus") || vtype.equals("truck"))
						bill = timespent * 70;
					System.out.print(bill);
				} while (resultSet.next());
			}

		} catch (ParseException e2) {
			e2.printStackTrace();
		} catch (Exception e1) {
			System.out.println("Error in connection");
			e1.printStackTrace();
		}
		bill = Math.round(bill * 100.0) / 100.0;
		results[4] = String.valueOf(bill);
		return results;
	}

	public void emptySpace(String RegNo) {
		String fNo = "";
		String pNo = "";
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\ParkingLotDatabase.accdb");// Establishing
																													// Connection
			System.out.println("Connected Successfully");
			PreparedStatement ps = connection
					.prepareStatement("select pNo,fNo from Vehicle where RegNo='" + RegNo + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fNo = rs.getString("fNo");
				pNo = rs.getString("pNo");
			}
			PreparedStatement preparedStatement3 = connection
					.prepareStatement("DELETE FROM Vehicle where RegNo='" + RegNo + "'");
			int c1 = preparedStatement3.executeUpdate();
			if (c1 > 0) {
				System.out.println("Record Deleted Successfully");

			}
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("update ParkingSlot set status=0 where pNo='" + pNo + "'and fNo='" + fNo + "'");
			int c = preparedStatement2.executeUpdate();
			if (c > 0) {
				System.out.print("successfully parking lot freed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public double calculateTime(String entryDate, String entryTime) throws ParseException {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(entryDate, dateFormatter);

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh.mm a");
		LocalTime time1 = LocalTime.parse(entryTime, timeFormatter);

		LocalDateTime entryDateTime = LocalDateTime.of(date1, time1);
		LocalDateTime exitDateTime = LocalDateTime.now();

		// Calculate time difference
		Duration duration = Duration.between(entryDateTime, exitDateTime);

		// Calculate time spent in hours with fractions
		double timeSpent = duration.toMinutes() / 60.0;
		System.out.println(timeSpent);
		return timeSpent;
	}

	private LocalDate parseDate(String dateString) {
		String[] parts = dateString.split("/");
		int day = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int year = Integer.parseInt(parts[2]);
		return LocalDate.of(year, month, day);
	}

}
