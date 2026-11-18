package app;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MovieTicketsApp extends JFrame {

    private final IMovieTickets tickets = new MovieTickets();

    // GUI components
    private final JComboBox<String> cmbMovie =
            new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
    private final JTextField txtNumber = new JTextField(10);
    private final JTextField txtPrice = new JTextField(10);
    private final JTextArea txtReport = new JTextArea(6, 25);

    public MovieTicketsApp() {
        setTitle("MOVIE TICKETS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top: labels and input controls in two columns
        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.add(new JLabel("MOVIE:"));
        form.add(cmbMovie);
        form.add(new JLabel("NUMBER OF TICKETS:"));
        form.add(txtNumber);
        form.add(new JLabel("TICKET PRICE:"));
        form.add(txtPrice);
        add(form, BorderLayout.NORTH);

        // Bottom: report label and read-only text area
        txtReport.setEditable(false);
        JPanel reportPanel = new JPanel(new BorderLayout(5, 5));
        reportPanel.add(new JLabel("TICKET REPORT:"), BorderLayout.NORTH);
        reportPanel.add(new JScrollPane(txtReport), BorderLayout.CENTER);
        add(reportPanel, BorderLayout.CENTER);

        buildMenu();

        pack();
        setLocationRelativeTo(null);   // centre on screen
    }

    // File > Exit    Tools > Process, Clear
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));          // Q2.3
        file.add(exit);

        JMenu tools = new JMenu("Tools");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");
        process.addActionListener(e -> processTickets());     // Q2.4
        clear.addActionListener(e -> clearForm());            // Q2.6
        tools.add(process);
        tools.add(clear);

        bar.add(file);
        bar.add(tools);
        setJMenuBar(bar);
    }

    // Capture, validate, calculate, display and save
    private void processTickets() {
        String movie = (String) cmbMovie.getSelectedItem();
        int number;
        double price;

        // Text fields give us text, so convert to numbers (letters will cause an error)
        try {
            number = Integer.parseInt(txtNumber.getText().trim());
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter numbers only for tickets and price.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Only valid data gets through (Q2.7)
        MovieTicketData data = new MovieTicketData(movie, number, price);
        if (!tickets.ValidateData(data)) {
            JOptionPane.showMessageDialog(this,
                    "Movie must be selected, and tickets and price must be greater than 0.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double total = tickets.CalculateTotalTicketPrice(number, price);

        String report = "MOVIE NAME: " + movie + "\n"
                + "MOVIE TICKET PRICE: R " + price + "\n"
                + "NUMBER OF TICKETS: " + number + "\n"
                + "TOTAL TICKET PRICE: R " + total;

        txtReport.setText(report);
        saveReport(report);
    }

    // Q2.5: write the report to report.txt
    private void saveReport(String report) {
        try (PrintWriter out = new PrintWriter(new FileWriter("report.txt"))) {
            out.println("MOVIE TICKET REPORT");
            out.println("************************************");
            out.println(report);
            out.println("************************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage());
        }
    }

    // Q2.6: back to the default state
    private void clearForm() {
        cmbMovie.setSelectedIndex(0);
        txtNumber.setText("");
        txtPrice.setText("");
        txtReport.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketsApp().setVisible(true));
    }
}
