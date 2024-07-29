package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSignup extends JFrame implements ActionListener {

    private JButton signUpbtn;
    private JButton loginbtn;
    private JButton backBtn;
    JPasswordField passwordpf;
    JTextField nametf,emailtf;
    Admin a;

    AdminSignup() {
    	a=new Admin();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100, 20, 930, 700);
        jf.setResizable(false);
        jf.setTitle("Admin Signup Form");
        Container c = jf.getContentPane();
        jf.setResizable(true);
        c.setLayout(null);

        c.setBackground(new Color(47, 57, 60));

        // iiui logo
        ImageIcon logo = new ImageIcon("signup.jpg");
        JLabel logolabel = new JLabel(logo);
        logolabel.setBounds(50, 80, 200, 225);
        c.add(logolabel);

        Font font = new Font("Serif", Font.BOLD, 40);
        JLabel label = new JLabel("ADMIN SIGN-UP FORM");
        label.setForeground(Color.WHITE);
        label.setFont(font);
        label.setBounds(300, 30, 800, 100);
        c.add(label);

        Font font1 = new Font("Boli", Font.PLAIN, 15);
        JLabel name = new JLabel(" Enter Username");
        name.setForeground(Color.WHITE);
        name.setFont(font1);
        name.setBounds(300, 140, 150, 30);
        c.add(name);

        JLabel email = new JLabel(" Enter Email");
        email.setFont(font1);
        email.setForeground(Color.WHITE);
        email.setBounds(300, 200, 150, 30);
        c.add(email);

        JLabel password = new JLabel(" Enter Password");
        password.setFont(font1);
        password.setForeground(Color.WHITE);
        password.setBounds(300, 260, 150, 30);
        c.add(password);

        nametf = new JTextField();
        nametf.setBounds(450, 140, 200, 30);
        setTextFieldStyle(nametf);
        c.add(nametf);

        emailtf = new JTextField();
        emailtf.setBounds(450, 200, 200, 30);
        setTextFieldStyle(emailtf);
        c.add(emailtf);

       passwordpf = new JPasswordField();
        passwordpf.setBounds(450, 260, 200, 30);
        setTextFieldStyle(passwordpf);
        c.add(passwordpf);

        signUpbtn = new JButton("Signup");
        signUpbtn.setBounds(500, 320, 100, 30);
        setButtonStyle(signUpbtn);
        c.add(signUpbtn);
        signUpbtn.addActionListener(this);

        Font font2 = new Font("Boli", Font.BOLD, 14);
        JLabel noAcc = new JLabel("If you already have an account");
        noAcc.setForeground(Color.WHITE);
        noAcc.setFont(font2);
        noAcc.setBounds(420, 380, 250, 30);
        c.add(noAcc);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(700, 380, 80, 30);
        setButtonStyle(loginbtn);
        c.add(loginbtn);
        loginbtn.addActionListener(this);

        backBtn = new JButton("Go Back");
        backBtn.setBounds(100, 420, 80, 30);
        setButtonStyle(backBtn);
        c.add(backBtn);
        backBtn.addActionListener(this);

        jf.setVisible(true);
    }

    private void setTextFieldStyle(JTextField textField) {
        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
    }

    private void setButtonStyle(JButton button) {
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbtn) {
            new AdminLogin();
        }

        if (e.getSource() == signUpbtn) {
        	boolean success=a.signup(nametf.getText(),String.valueOf(passwordpf.getPassword()) ,emailtf.getText());
        	if(success) {
        		AdminDashboard ad=new AdminDashboard();
        		ad.setVisible(true);
        		this.setVisible(false);
        		this.dispose();
        	}
        	else
        		JOptionPane.showMessageDialog(null, "An error occurred, while signing up","SignUp failed",JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == backBtn) {
            new AdminLogin();
            this.setVisible(false);
            this.dispose();
        }
    }


    public static void main(String[] args) {
        AdminSignup m = new AdminSignup();
    }
}
