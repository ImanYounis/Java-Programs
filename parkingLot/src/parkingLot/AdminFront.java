package parkingLot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFront {
	private JLabel image;
	JButton logout = new JButton("Log Out");
	JButton add = new JButton("Add Vehicle");
	JButton view = new JButton("View Parking");
	JButton search = new JButton("Search Out");
	JButton bill = new JButton("Calculate Bill");
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel(new FlowLayout());
	JPanel p3 = new JPanel(new FlowLayout());
	JPanel p4 = new JPanel(new FlowLayout());
	JPanel p5 = new JPanel(new FlowLayout());
	JPanel p6 = new JPanel(new FlowLayout());
	JPanel main = new JPanel(new GridLayout(5, 1, 5, 5));
	JPanel main1 = new JPanel(new BorderLayout());
	AdminBack admin = new AdminBack();

	AdminFront() {
		JFrame frame = new JFrame();
		frame.setTitle("Admin Panel");
		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		p1.add(logout);
		p2.add(add);
		p3.add(view);
		p4.add(search);
		p5.add(bill);
		main.add(p1);
		main.add(p2);
		main.add(p3);
		main.add(p4);
		main.add(p5);
		ImageIcon imageicon = new ImageIcon("bg2.jpg");
		image = new JLabel(imageicon);
		p6.add(image);
		main1.add(p6, BorderLayout.WEST);
		main1.add(main, BorderLayout.EAST);
		frame.add(main1);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.logout();
				frame.setVisible(false);
				//new Login();
			}
		});
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddVehicleFront();
			}
		});
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchVehicleFront();
			}
		});
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewFront();
			}
		});
		bill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BillFront();
			}
		});
	}
}
