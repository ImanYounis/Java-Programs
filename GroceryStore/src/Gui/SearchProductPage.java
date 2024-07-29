package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchProductPage extends JFrame implements ActionListener {
    private JTextField searchNameField;
    private JTextField searchIdField;
    private JTextArea productDetailsArea;
    private JButton searchButton;

    public SearchProductPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Search Product");
        getContentPane().setBackground(new Color(47, 57, 60));
        Container container = getContentPane();
        container.setLayout(null);

        JLabel searchNameLabel = createLabel(" Product Name");
        searchNameLabel.setBounds(50, 20, 150, 30);
        container.add(searchNameLabel);

        searchNameField = createTextField();
        searchNameField.setBounds(200, 20, 250, 30);
        container.add(searchNameField);

        JLabel searchIdLabel = createLabel(" Product ID");
        searchIdLabel.setBounds(50, 70, 150, 30);
        container.add(searchIdLabel);

        searchIdField = createTextField();
        searchIdField.setBounds(200, 70, 250, 30);
        container.add(searchIdField);

        searchButton = createButton("Search", 150, 30);
        searchButton.setBounds((getWidth() - 150) / 2, 120, 150, 30);
        container.add(searchButton);

        productDetailsArea = createTextArea();
        productDetailsArea.setBounds(50, 170, 400, 150);
        container.add(productDetailsArea);

        // Action listener
        searchButton.addActionListener(this);
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
        textArea.setEditable(false);
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
        if (e.getSource() == searchButton) {

            String searchName = searchNameField.getText();
            String searchId = searchIdField.getText();

            String productDetails = getProductDetails(searchName, searchId);

            productDetailsArea.setText(productDetails);
        }
    }

    private String getProductDetails(String searchName, String searchId) {

        String productDetails = "";
        if (!searchName.isEmpty()) {
            // Search by Name
            productDetails = "Product Name: " + searchName + "\n" +
                    "Product ID: 123\n" +
                    "Product Price: 50.00\n" +
                    "Product Description: This is a sample product.";
        } else if (!searchId.isEmpty()) {
            // Search by ID
            productDetails = "Product Name: Sample Product\n" +
                    "Product ID: " + searchId + "\n" +
                    "Product Price: $50.00\n" +
                    "Product Description: This is a sample product.";
        } else {

            productDetails = "Please provide either Product Name or Product ID for the search.";
        }
        return productDetails;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SearchProductPage searchProductPage = new SearchProductPage();
            searchProductPage.setVisible(true);
        });
    }
}

