package app;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductSalesApp extends JFrame {

    private final IProductSales sales = new ProductSales();

    // GUI components
    private final JButton btnLoad = new JButton("Load Product Data");
    private final JButton btnSave = new JButton("Save Product Data");
    private final JTextArea txtReport = new JTextArea(6, 25);
    private final JLabel lblYears = new JLabel(" ");

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Buttons at the top (stacked)
        JPanel top = new JPanel(new GridLayout(2, 1, 5, 5));
        top.add(btnLoad);
        top.add(btnSave);
        add(top, BorderLayout.NORTH);

        // Read-only text area in the middle
        txtReport.setEditable(false);
        add(new JScrollPane(txtReport), BorderLayout.CENTER);

        // Years processed label at the bottom
        add(lblYears, BorderLayout.SOUTH);

        buildMenu();

        // Buttons and menu items call the SAME methods
        btnLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());

        pack();
        setLocationRelativeTo(null);   // centre on screen
    }

    // File > Exit, Tools > Load / Save / Clear
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem load = new JMenuItem("Load Product Data");
        JMenuItem save = new JMenuItem("Save Product Data");
        JMenuItem clear = new JMenuItem("Clear");
        load.addActionListener(e -> loadData());
        save.addActionListener(e -> saveData());
        clear.addActionListener(e -> clearData());
        tools.add(load);
        tools.add(save);
        tools.add(clear);

        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);
    }

    // Fill the text area with the calculated results
    private void loadData() {
        txtReport.setText(
            "Total Sales: " + sales.GetTotalSales() + "\n" +
            "Average Sales: " + Math.round(sales.GetAverageSales()) + "\n" +
            "Sales over limit: " + sales.GetSalesOverLimit() + "\n" +
            "Sales under limit: " + sales.GetSalesUnderLimit());
        lblYears.setText("Years Processed: " + sales.GetProductsProcessed());
    }

    // Write the text area contents to data.txt
    private void saveData() {
        if (txtReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Load the product data first.");
            return;
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt"))) {
            out.println("DATA LOG");
            out.println("**********************************");
            out.println(txtReport.getText());
            out.println("**********************************");
            JOptionPane.showMessageDialog(this, "Saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage());
        }
    }

    // Empty the text area and the label
    private void clearData() {
        txtReport.setText("");
        lblYears.setText(" ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}
