package parkingLot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login {
	private static boolean isLoggedIn=false;
	Login() {
		boolean result = true;
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		JPanel p4 = new JPanel(new GridLayout(3, 2, 5, 5));
		JButton login = new JButton("Log In");
		JLabel namel = new JLabel("Enter Name:");
		JLabel pswdl = new JLabel("Enter Password:");
		JTextField name = new JTextField("");
		JTextField pswd = new JTextField("");
		p1.add(login);
		p2.add(name);
		p3.add(pswd);
		p4.add(namel);
		p4.add(name);
		p4.add(pswdl);
		p4.add(pswd);
		p4.add(login);
		JFrame frame = new JFrame();
		frame.setTitle("Admin Panel");
		frame.setSize(400, 150);
		frame.setLocationRelativeTo(null);
		frame.add(p4);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminBack log = new AdminBack();
				if(name.getText().equals("")||pswd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You can't leave the name and password fields empty","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				boolean result = log.login(name.getText(), pswd.getText());
				if (result) {
					new AdminFront();
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or password is wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public static void main(String[] args) {
		if(!isLoggedIn)
			new Login();
	}

	public static boolean isLoggedIn() {
		return isLoggedIn;
	}

	public static void setLoggedIn(boolean isLoggedIn) {
		Login.isLoggedIn = isLoggedIn;
	}
}
