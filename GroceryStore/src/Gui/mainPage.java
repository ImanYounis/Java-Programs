package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPage extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton admin;

    mainPage() {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(100, 100, 800, 600);
        jf.setResizable(false);
        jf.setTitle("GROCERY STORE");
        Container c = jf.getContentPane();
        jf.setResizable(true);
        c.setLayout(null);

        c.setBackground(new Color(47, 57, 60));

        // iiui logo
        ImageIcon logo = new ImageIcon("download.jpg");
        JLabel logolabel = new JLabel(logo);
        logolabel.setBounds(250, 50, 300, 200);
        c.add(logolabel);

        Font font = new Font("Serif", Font.BOLD, 30);
        JLabel label = new JLabel("SAMZ GROCERY STORE");
        label.setFont(font);
        label.setBounds(210, 270, 400, 70);
        label.setForeground(Color.WHITE);
        c.add(label);

Font font1=new Font("Serif", Font.BOLD, 40);
        admin = new JButton("ADMIN DASHBOARD");
        admin.setBounds(300, 360, 200, 50);
        admin.setBackground(Color.GRAY);  // Set button background color
        admin.setForeground(Color.WHITE);  // Set button text color
        admin.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        admin.addActionListener(this);
        c.setFont(font1);
        c.add(admin);

        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin) {
            admin.setBackground(Color.DARK_GRAY);
            new AdminLogin();
        }
    }

    public static void main(String[] args) {
        new mainPage();
    }
}
