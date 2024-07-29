package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductPage extends JFrame implements ActionListener {
    private JTextField productIdField;
    private JTextField updatedNameField;
    private JTextField updatedPriceField;
    private JTextArea updatedDescriptionArea;
    private JButton updateButton;

    public UpdateProductPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Update Product");
        getContentPane().setBackground(new Color(47, 57, 60));

        Container container = getContentPane();
        container.setLayout(null);

        JLabel productIdLabel = createLabel(" Product ID");
        productIdLabel.setBounds(50, 20, 150, 30);
        container.add(productIdLabel);

        productIdField = createTextField();
        productIdField.setBounds(200, 20, 250, 30);
        container.add(productIdField);

        JLabel updatedNameLabel = createLabel(" Product Name");
        updatedNameLabel.setBounds(50, 70, 150, 30);
        container.add(updatedNameLabel);

        updatedNameField = createTextField();
        updatedNameField.setBounds(200, 70, 250, 30);
        container.add(updatedNameField);

        JLabel updatedPriceLabel = createLabel(" Product Price");
        updatedPriceLabel.setBounds(50, 120, 150, 30);
        container.add(updatedPriceLabel);

        updatedPriceField = createTextField();
        updatedPriceField.setBounds(200, 120, 250, 30);
        container.add(updatedPriceField);

        JLabel updatedDescriptionLabel = createLabel(" Product Description");
        updatedDescriptionLabel.setBounds(50, 170, 200, 30);
        container.add(updatedDescriptionLabel);

        updatedDescriptionArea = createTextArea();
        updatedDescriptionArea.setBounds(200, 170, 250, 80);
        container.add(updatedDescriptionArea);

        updateButton = createButton("Update", 150, 30);
        updateButton.setBounds((getWidth() - 150) / 2, 270, 150, 30);
        container.add(updateButton);

        updateButton.addActionListener(this);
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
        if (e.getSource() == updateButton) {

            String productId = productIdField.getText();
            String updatedName = updatedNameField.getText();
            String updatedPrice = updatedPriceField.getText();
            String updatedDescription = updatedDescriptionArea.getText();

            JOptionPane.showMessageDialog(this, "Product updated successfully!");

            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UpdateProductPage updateProductPage = new UpdateProductPage();
            updateProductPage.setVisible(true);
        });
    }
}

