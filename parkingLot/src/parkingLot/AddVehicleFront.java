package parkingLot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

public class AddVehicleFront extends JFrame {
	JTextField OwnerName = new JTextField();
	JTextField Type = new JTextField();
	JTextField RegNo = new JTextField();
	JTextField Color = new JTextField();
	JTextField model = new JTextField();
	JComboBox<String> ParkingSlot;
	JLabel OwnerLabel = new JLabel("Enter Owner Name:");
	JLabel TypeLabel = new JLabel("Enter Vehicle Type:");
	JLabel RegNoLabel = new JLabel("Enter Plate No. :");
	JLabel colorLabel = new JLabel("Enter Color:");
	JLabel modelLabel = new JLabel("Enter Model:");
	JLabel assignLabel = new JLabel("Not Assigned");
	JLabel OwnerLabelerror = new JLabel("");
	JLabel TypeLabelerror = new JLabel("");
	JLabel RegNoLabelerror = new JLabel("");
	JLabel colorLabelerror = new JLabel("");
	JLabel modelLabelerror = new JLabel("");
	private JLabel image;
	ImageIcon imageicon = new ImageIcon("addvehicle1.png");
	JPanel main = new JPanel(new BorderLayout());
	JPanel data = new JPanel(new GridLayout(7, 2, 10, 10));
	JPanel imgPanel = new JPanel();
	JButton submit = new JButton("Add Vehicle");
	JButton assign = new JButton("Assign");

	AddVehicleFront() {
		JFrame frame = new JFrame();
		JFrame assignParking = new JFrame("Assign Parking Slot");
		frame.setTitle("Add Vehicle to Database");
		frame.setSize(1200, 300);
		frame.setLocationRelativeTo(null);
		image = new JLabel(imageicon);
		imgPanel.add(image);
		OwnerName.setColumns(15);
		Type.setColumns(15);
		Color.setColumns(15);
		data.add(OwnerLabel);
		data.add(OwnerName);
		data.add(OwnerLabelerror);
		data.add(TypeLabel);
		data.add(Type);
		data.add(TypeLabelerror);
		data.add(RegNoLabel);
		data.add(RegNo);
		data.add(RegNoLabelerror);
		data.add(colorLabel);
		data.add(Color);
		data.add(colorLabelerror);
		data.add(modelLabel);
		data.add(model);
		data.add(modelLabelerror);
		data.add(submit);
		main.add(imgPanel, BorderLayout.WEST);
		main.add(data, BorderLayout.EAST);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JPanel dropDown = new JPanel(new BorderLayout());
				AddVehicleBack v1 = new AddVehicleBack();
				String regNo = RegNo.getText();
				String ownerName = OwnerName.getText();
				String getmodel = model.getText();
				String color = Color.getText();
				String type = Type.getText();
				String regNoPattern = "^[A-Z]{3}-\\d{4}$";
				String namePattern = "^[a-zA-Z\\s]{1,50}$";
				String modelPattern = "^[a-zA-Z0-9]+\s[0-9a-zA-Z0-9]+$";
				String colorPattern = "^[a-zA-Z]{1,15}$";
				String typePattern = "^(bike|car|truck|bus)$";
				int flag[] = { 1, 1, 1, 1, 1 };
				if (!regNo.matches(regNoPattern)) {
					RegNoLabelerror.setText("Format is: XXX-####");
					flag[0] = 0;
				} else {
					flag[0] = 1;
					RegNoLabelerror.setText("");
				}

				if (!ownerName.matches(namePattern)) {
					OwnerLabelerror.setText("Name should contain alphabets only");
					flag[1] = 0;
				} else {
					flag[1] = 1;
					OwnerLabelerror.setText("");
				}

				if (!getmodel.matches(modelPattern)) {
					modelLabelerror.setText("Format is: XXXxxx ### XXXxxx or xxxXXX xxxXXX");
					flag[2] = 0;
				} else {
					flag[2] = 1;
					modelLabelerror.setText("");
				}

				if (!color.matches(colorPattern)) {
					colorLabelerror.setText("Color should contain alphabets only");
					flag[3] = 0;
				} else {
					flag[3] = 1;
					colorLabelerror.setText("");
				}

				if (!type.toLowerCase().matches(typePattern)) {
					TypeLabelerror.setText("Type should contain bike,bus,truck,car only");
					flag[4] = 0;
				} else {
					flag[4] = 1;
					TypeLabelerror.setText("");
				}
				if (flag[0] == 1 && flag[1] == 1 && flag[2] == 1 && flag[3] == 1 && flag[4] == 1)
					try {
						ResultSet result = v1.getFreeParkingSlots(Type.getText().toLowerCase());
						String ParkingSlots[] = new String[20];
						int count = 0;
						while (result.next()) {
							ParkingSlots[count] = "" + result.getInt("pNo") + "--" + result.getString("fNo");
							count++;
						}
						ParkingSlot = new JComboBox<String>(ParkingSlots);
						dropDown.add(ParkingSlot, BorderLayout.WEST);
						dropDown.add(assign, BorderLayout.EAST);
						dropDown.add(assignLabel, BorderLayout.SOUTH);
						assignParking.add(dropDown);
						assignParking.setSize(400, 80);
						assignParking.setLocationRelativeTo(null);
						assignParking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						assignParking.setVisible(true);
					} catch (Exception exp) {
						exp.printStackTrace();
					}

			}

		});
		assign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddVehicleBack v1 = new AddVehicleBack();
				ParkingSlot p1 = new ParkingSlot();
				String regNo = RegNo.getText();
				String ownerName = OwnerName.getText();
				String getmodel = model.getText();
				String color = Color.getText();
				String type = Type.getText();
				String parkingSlot = (String) ParkingSlot.getSelectedItem();
				v1.databaseSubmit(regNo, ownerName, getmodel, color, type, parkingSlot);
				String parkingAddress = (String) ParkingSlot.getSelectedItem();
				p1.changeParkingSlotStatus(parkingAddress);
				assign.setEnabled(false);
				assignLabel.setText(parkingAddress + " assigned successfully to Plate NO: " + regNo);
				RegNo.setText("");
				OwnerName.setText("");
				model.setText("");
				Color.setText("");
				Type.setText("");
			}
		});
		assignParking.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                assign.setEnabled(true);
                assignLabel.setText("Assigned Successfully");
            }
        });
		assignLabel.setText("Not Assigned");
		assign.setEnabled(true);
	}
}
