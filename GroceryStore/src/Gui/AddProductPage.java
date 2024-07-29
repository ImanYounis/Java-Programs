package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductPage extends JFrame implements ActionListener {
    private JTextField productIdField;
    private JTextField productNameField;
    private JTextField productPriceField;
    private JTextArea productDescriptionArea;
    private JButton submitButton;
    Admin a;

    public AddProductPage() {
    	a=new Admin();
        // Frame setup
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the frame
        setTitle("Add Product");
        getContentPane().setBackground(new Color(74, 90, 95)); // Set background color

        Container container = getContentPane();
        container.setLayout(null);

        JLabel productIdLabel = createLabel(" Product ID");
        productIdLabel.setBounds(50, 20, 150, 30);
        container.add(productIdLabel);

        productIdField = createTextField();
        productIdField.setBounds(200, 20, 250, 30);
        container.add(productIdField);

        JLabel productNameLabel = createLabel(" Product Name");
        productNameLabel.setBounds(50, 70, 150, 30);
        container.add(productNameLabel);

        productNameField = createTextField();
        productNameField.setBounds(200, 70, 250, 30);
        container.add(productNameField);

        JLabel productPriceLabel = createLabel(" Product Price");
        productPriceLabel.setBounds(50, 120, 150, 30);
        container.add(productPriceLabel);

        productPriceField = createTextField();
        productPriceField.setBounds(200, 120, 250, 30);
        container.add(productPriceField);

        JLabel productDescriptionLabel = createLabel(" Product Description");
        productDescriptionLabel.setBounds(50, 170, 150, 30);
        container.add(productDescriptionLabel);

        productDescriptionArea = createTextArea();
        productDescriptionArea.setBounds(200, 170, 250, 80);
        container.add(productDescriptionArea);

        submitButton = createButton("Submit", 150, 30);
        submitButton.setBounds((getWidth() - 150) / 2, 270, 150, 30);
        container.add(submitButton);

        submitButton.addActionListener(this);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Boli", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBackground(Color.GRAY);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        return textField;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        return textArea;
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
        if (e.getSource() == submitButton) {
            String productId = productIdField.getText();
            String productName = productNameField.getText();
            String productPrice = productPriceField.getText();
            String productDescription = productDescriptionArea.getText();

            boolean added=a.addProduct(productName, Integer.parseInt(productPrice), productDescription);
            if(added) {
            JOptionPane.showMessageDialog(this, "Product added successfully!");

            dispose();
            }
            else {
            	JOptionPane.showMessageDialog(this, "Couldn't add product");
            }
        }
    }

    public static void main(String[] args) {
        // For testing purposes
        SwingUtilities.invokeLater(() -> {
            AddProductPage addProductPage = new AddProductPage();
            addProductPage.setVisible(true);
        });
    }
}
