package parkingLot;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchVehicleFront {
	JComboBox<String> Search;
	String[] search = { "Plate NO", "Owner Name", "Model", "Type" };
	JButton find = new JButton("Search");
	JLabel data = new JLabel("Nothing to show here");
	JPanel jpM = new JPanel();
	JPanel outerdata = new JPanel();
	JPanel Outer = new JPanel(new BorderLayout());
	JTextField input = new JTextField("Enter.....");
	JPanel jp = new JPanel();
	ArrayList<JPanel> jparray = new ArrayList<JPanel>();
	JPanel flowbtn = new JPanel(new FlowLayout());
	JPanel flowdrop = new JPanel(new FlowLayout());
	JPanel flowfield = new JPanel(new FlowLayout());
	int flag = 1;

	SearchVehicleFront() {
		JFrame frame = new JFrame();
		frame.setTitle("Search the Vehicle");
		frame.setSize(500, 400);
		frame.getContentPane().setBackground(Color.white);
		frame.setLocationRelativeTo(null);
		Search = new JComboBox<String>(search);
		input.setColumns(15);
		flowbtn.add(find);
		flowdrop.add(Search);
		flowfield.add(input);
		jp.add(data);
		outerdata.setLayout(new BoxLayout(outerdata, BoxLayout.Y_AXIS));
		outerdata.add(data);
		outerdata.add(jpM);
		Outer.add(flowdrop, BorderLayout.WEST);
		Outer.add(flowfield, BorderLayout.CENTER);
		Outer.add(flowbtn, BorderLayout.EAST);
		Outer.add(outerdata, BorderLayout.SOUTH);
		frame.add(Outer);
		JScrollPane scrollPane = new JScrollPane(Outer);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scrollPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getsearch = (String) Search.getSelectedItem();
				SearchVehicleBack v1 = new SearchVehicleBack();
				ResultSet result = null;
				try {
					if (flag == 0) {
						jpM.removeAll();
						jpM.revalidate();
						jpM.repaint();
					}
					if ("Plate NO".equals(getsearch)) {
						result = v1.searchreg(input.getText());
					}
					if ("Owner Name".equals(getsearch)) {
						result = v1.searchname(input.getText());
					}
					if ("Model".equals(getsearch)) {
						result = v1.searchmodel(input.getText());
					}
					if ("Type".equals(getsearch)) {
						result = v1.searchtype(input.getText());
					}
					if(result==null) {
						data.setText("No Record Found");
						//return;
					}
					else {
					while (result.next()) {
						flag = 0;
						data.setText("Record Found");
						JPanel jp1 = new JPanel(new GridLayout(8, 2, 5, 5));
						TitledBorder title = BorderFactory.createTitledBorder("" + result.getString("RegNo"));
						jp1.setBorder(title);
						JLabel OwnerLabel = new JLabel("Owner Name:");
						JLabel TypeLabel = new JLabel("Vehicle Type:");
						JLabel RegNoLabel = new JLabel("Plate No. :");
						JLabel colorLabel = new JLabel("Color:");
						JLabel modelLabel = new JLabel("Model:");
						JLabel assignLabel = new JLabel("Parking Slot Assigned:");
						JLabel EntryTime = new JLabel("Entry Time:");
						JLabel OwnerLabeldata = new JLabel("");
						JLabel TypeLabeldata = new JLabel("");
						JLabel RegNoLabeldata = new JLabel("");
						JLabel colorLabeldata = new JLabel("");
						JLabel modelLabeldata = new JLabel("");
						JLabel assignLabeldata = new JLabel("");
						JLabel EntryTimedata = new JLabel("");
						OwnerLabeldata.setText(result.getString("OwnerName"));
						TypeLabeldata.setText(result.getString("vehicleType"));
						RegNoLabeldata.setText(result.getString("RegNo"));
						modelLabeldata.setText("" + result.getString("model"));
						assignLabeldata.setText("" + result.getString("pNo") + "--" + result.getString("fNo"));
						EntryTimedata.setText("" + result.getString("entryTime"));
						colorLabeldata.setText("" + result.getString("color"));
						jp1.add(OwnerLabel);
						jp1.add(OwnerLabeldata);
						jp1.add(TypeLabel);
						jp1.add(TypeLabeldata);
						jp1.add(RegNoLabel);
						jp1.add(RegNoLabeldata);
						jp1.add(colorLabel);
						jp1.add(colorLabeldata);
						jp1.add(modelLabel);
						jp1.add(modelLabeldata);
						jp1.add(assignLabel);
						jp1.add(assignLabeldata);
						jp1.add(EntryTime);
						jp1.add(EntryTimedata);
						 jparray.add(jp1);
                	}
					}
                	jpM.setLayout(new GridLayout(jparray.size(),2,5,5));
                	 for (JPanel panel : jparray) {
                         jpM.add(panel);
                     }
                	 jparray.clear();
               }
              catch(Exception e1) {
            	   e1.printStackTrace();
               }
    		}
        });
		
	}

}
