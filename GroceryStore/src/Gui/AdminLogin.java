package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminLogin extends JFrame implements ActionListener {
    private JButton signUpbtn;
    private JButton loginbtn;
    private JButton backBtn;
    JPasswordField passwordpf;
    JTextField nametf;
    Admin a;

    AdminLogin() {
    	a=new Admin();
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100, 20, 930, 700);
        jf.setResizable(false);
        jf.setTitle("Admin Login Form");
        Container c = jf.getContentPane();
        jf.setResizable(true);
        c.setLayout(null);

        c.setBackground(new Color(47, 57, 60));

        // iiui logo
        ImageIcon logo = new ImageIcon("login.jpg");
        JLabel logolabel = new JLabel(logo);
        int logoWidth = 180;
        int logoHeight = 330;

        logolabel.setBounds(50, 50, logoWidth, logoHeight);

        c.add(logolabel);

        Font font = new Font("Serif", Font.BOLD, 40);
        JLabel label = new JLabel("ADMIN LOGIN FORM");
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBounds(300, 30, 800, 100);
        c.add(label);

        Font font1 = new Font("Boli", Font.PLAIN, 15);
        JLabel name = new JLabel("Enter Username");
        name.setForeground(Color.WHITE);
        name.setFont(font1);
        name.setBounds(300, 140, 150, 30);
        c.add(name);

        JLabel password = new JLabel("Enter Password");
        password.setFont(font1);
        password.setBounds(300, 200, 150, 30);
        password.setForeground(Color.WHITE);
        c.add(password);

        nametf = new JTextField();
        nametf.setBounds(450, 140, 200, 30);
        setTextFieldStyle(nametf);
        c.add(nametf);

        passwordpf = new JPasswordField();
        passwordpf.setFont(font);
        passwordpf.setBounds(450, 200, 200, 30);
        setTextFieldStyle(passwordpf);
        c.add(passwordpf);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(500, 260, 100, 30);
        setButtonStyle(loginbtn);
        c.add(loginbtn);
        loginbtn.addActionListener(this);

        Font font2 = new Font("Boli", Font.BOLD, 14);
        JLabel noAcc = new JLabel("If You Want to Create new account");
        noAcc.setForeground(Color.WHITE);
        noAcc.setFont(font2);
        noAcc.setBounds(420, 330, 250, 30);
        c.add(noAcc);

        signUpbtn = new JButton("SignUp");
        signUpbtn.setBounds(700, 330, 80, 30);
        setButtonStyle(signUpbtn);
        c.setFont(font1);
        c.add(signUpbtn);
        signUpbtn.addActionListener(this);

        backBtn = new JButton("Go Back");
        backBtn.setBounds(100, 380, 80, 30);
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
        if (e.getSource() == signUpbtn) {
            new AdminSignup();
        }
        if(e.getSource()==loginbtn) {
        	boolean success=false;
        	success=a.login(nametf.getText(),String.valueOf(passwordpf.getPassword()));
        	if(success) {
        		AdminDashboard ad=new AdminDashboard();
        		ad.setVisible(true);
        		this.setVisible(false);
        		this.dispose();
        	}
        	else
        		JOptionPane.showMessageDialog(null, "Please check username and password and try again","Login Failed!",JOptionPane.ERROR_MESSAGE);
        }
        if (e.getSource() == backBtn) {
            new mainPage();
            this.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        AdminLogin m = new AdminLogin();
    }
}
