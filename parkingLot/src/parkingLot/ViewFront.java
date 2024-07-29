package parkingLot;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.ResultSet;

public class ViewFront {
	ViewBack v1 = new ViewBack();
	private JLabel image;
	ImageIcon imageicon = new ImageIcon("parking.png");
	TitledBorder titleb1 = BorderFactory.createTitledBorder("Floor B1");
	TitledBorder titleb2 = BorderFactory.createTitledBorder("Floor B2");
	TitledBorder titleb3 = BorderFactory.createTitledBorder("Floor B3");
	JLabel jlf;
	JLabel jlr;
	JTextField tfr,tff;

	ViewFront() {
		image = new JLabel(imageicon);
		JPanel main = new JPanel(new GridLayout(4, 1, 10, 10));
		JPanel f1 = new JPanel();
		f1.setBorder(titleb1);
		JPanel f2 = new JPanel();
		f2.setBorder(titleb2);
		
		JPanel f3 = new JPanel();
		f3.setBorder(titleb3);
		JFrame frame = new JFrame();
		frame.setTitle("View Parking");
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		f1.setLayout(new GridLayout(5, 3, 5, 5));
		f2.setLayout(new GridLayout(5, 3, 5, 5));
		f3.setLayout(new GridLayout(5, 3, 5, 5));
		
		jlf=new JLabel("Total Free Slots: ");
		jlr=new JLabel("Total Reserved Slots: ");
		tfr=new JTextField("");
		tff=new JTextField("");
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(1,4,5,5));
		jp.add(jlf);jp.add(tff);
		jp.add(jlr);jp.add(tfr);
		
		ResultSet resultb1 = v1.getParkingSlotsf1();
		int countf=0,countr=0;
		try {
			while (resultb1.next()) {
				if (resultb1.getInt("status") == 1) {
					JLabel pNo = new JLabel("🚗");
					f1.add(pNo);
					countr++;
				} else {
					JLabel pNo = new JLabel("" + resultb1.getInt("pNo"));
					f1.add(pNo);
					countf++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet resultb2 = v1.getParkingSlotsf2();
		try {
			while (resultb2.next()) {
				if (resultb2.getInt("status") == 1) {
					JLabel pNo = new JLabel("🚗");
					f2.add(pNo);
					countr++;
				} else {
					JLabel pNo = new JLabel("" + resultb2.getInt("pNo"));
					f2.add(pNo);
					countf++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet resultb3 = v1.getParkingSlotsf3();
		try {
			while (resultb3.next()) {
				if (resultb3.getInt("status") == 1) {
					JLabel pNo = new JLabel("🚗");
					f3.add(pNo);
					countr++;
				} else {
					JLabel pNo = new JLabel("" + resultb3.getInt("pNo"));
					f3.add(pNo);
					countf++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tff.setText(String.valueOf(countf));
		tfr.setText(String.valueOf(countr));
		main.add(f1);
		main.add(f2);
		main.add(f3);
		main.add(jp);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
