package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductPage extends JFrame implements ActionListener {
    private JTextField productIdField;
    private JButton deleteButton;

    public DeleteProductPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setTitle("Delete Product");
        getContentPane().setBackground(new Color(47, 57, 60));

        Container container = getContentPane();
        container.setLayout(null);

        JLabel productIdLabel = createLabel("Product ID");
        productIdLabel.setBounds(50, 50, 100, 30);
        container.add(productIdLabel);

        productIdField = createTextField();
        productIdField.setBounds(150, 50, 200, 30);
        container.add(productIdField);

        deleteButton = createButton("Delete", 100, 30);
        deleteButton.setBounds((getWidth() - 100) / 2, 120, 100, 30);
        container.add(deleteButton);

        deleteButton.addActionListener(this);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Boli", Font.PLAIN, 14));
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

    private JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        button.setFocusPainted(false);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String productId = productIdField.getText();

            JOptionPane.showMessageDialog(this, "Product deleted successfully!");

            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeleteProductPage deleteProductPage = new DeleteProductPage();
            deleteProductPage.setVisible(true);
        });
    }
}

