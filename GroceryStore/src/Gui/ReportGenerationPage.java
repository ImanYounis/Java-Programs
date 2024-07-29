package Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportGenerationPage extends JFrame implements ActionListener {
    private JButton backButton;
    private JTable reportTable;
    private JScrollPane tableScrollPane;

    public ReportGenerationPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Report Generation Page");
        getContentPane().setBackground(new Color(47, 57, 60));

        Container container = getContentPane();
        container.setLayout(null);

        reportTable = createTable();
        tableScrollPane = new JScrollPane(reportTable);
        tableScrollPane.setBounds(50, 50, 700, 400);
        container.add(tableScrollPane);

        backButton = createButton("Back", 150, 30);
        backButton.setBounds((getWidth() - 150) / 2, 500, 150, 30);
        container.add(backButton);

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

    private JTable createTable() {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Product ID");
        model.addColumn("Product Name");
        model.addColumn("Product Price");
        model.addColumn("Product Description");

        model.addRow(new Object[]{"1", "Product A", "$20.00", "Description A"});
        model.addRow(new Object[]{"2", "Product B", "$25.00", "Description B"});
        model.addRow(new Object[]{"3", "Product C", "$30.00", "Description C"});

        return new JTable(model);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {

            dispose();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ReportGenerationPage reportGenerationPage = new ReportGenerationPage();
            reportGenerationPage.setVisible(true);
        });
    }
}
