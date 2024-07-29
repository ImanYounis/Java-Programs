package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame implements ActionListener {
    private JButton logoutBtn;
    private JButton addProductBtn;
    private JButton deleteProductBtn;
    private JButton searchProductBtn;
    private JButton updateProductBtn;
    private JButton generateReportBtn;
    private JButton backButton;
    private JLabel welcomeLabel;

    public AdminDashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Admin Dashboard");

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(47, 57, 60));

        Font welcomeFont = new Font("Serif", Font.BOLD, 30);
        welcomeLabel = new JLabel("WELCOME TO YOUR DASHBOARD!");
        welcomeLabel.setFont(welcomeFont);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds((getWidth() - 600) / 2, 50, 600, 80);
        container.add(welcomeLabel);

        int buttonWidth = 200;
        int buttonHeight = 40;
        int verticalGap = 40;

        addProductBtn = createButton("Add Product", buttonWidth, buttonHeight);
        addProductBtn.setBounds((getWidth() - buttonWidth) / 2, 180, buttonWidth, buttonHeight);
        container.add(addProductBtn);

        deleteProductBtn = createButton("Delete Product", buttonWidth, buttonHeight);
        deleteProductBtn.setBounds((getWidth() - buttonWidth) / 2, 180 + verticalGap, buttonWidth, buttonHeight);
        container.add(deleteProductBtn);

        searchProductBtn = createButton("Search Product", buttonWidth, buttonHeight);
        searchProductBtn.setBounds((getWidth() - buttonWidth) / 2, 180 + 2 * verticalGap, buttonWidth, buttonHeight);
        container.add(searchProductBtn);

        updateProductBtn = createButton("Update Product", buttonWidth, buttonHeight);
        updateProductBtn.setBounds((getWidth() - buttonWidth) / 2, 180 + 3 * verticalGap, buttonWidth, buttonHeight);
        container.add(updateProductBtn);

        generateReportBtn = createButton("Generate Report", buttonWidth, buttonHeight);
        generateReportBtn.setBounds((getWidth() - buttonWidth) / 2, 180 + 4 * verticalGap, buttonWidth, buttonHeight);
        container.add(generateReportBtn);

        backButton = createButton("Back", buttonWidth, buttonHeight);
        backButton.setBounds(50, 500, buttonWidth, buttonHeight);
        container.add(backButton);

        logoutBtn = createButton("Logout", buttonWidth, buttonHeight);
        logoutBtn.setBounds(getWidth() - 50 - buttonWidth, 500, buttonWidth, buttonHeight);
        container.add(logoutBtn);

        addProductBtn.addActionListener(this);
        deleteProductBtn.addActionListener(this);
        searchProductBtn.addActionListener(this);
        updateProductBtn.addActionListener(this);
        generateReportBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        backButton.addActionListener(this);
    }

    private JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        button.setFocusPainted(false);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutBtn) {
            int response = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {

                dispose();
                new mainPage().setVisible(true);
            }
        } else if (e.getSource() == backButton) {

            new AdminLogin().setVisible(true);
            dispose();
        } else {

            JOptionPane.showMessageDialog(this, e.getActionCommand() + " functionality goes here.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminDashboard adminDashboard = new AdminDashboard();
            adminDashboard.setVisible(true);
        });
    }
}
