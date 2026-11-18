package app;

public class Main {
    public static void main(String[] args) {

        // Single-dimensional arrays for the labels
        String[] quarters = {"QUARTER 1", "QUARTER 2", "QUARTER 3"};
        String[] years = {"YEAR 1", "YEAR 2"};

        // Two-dimensional array: rows = years, columns = quarters
        int[][] sales = {
            {300, 150, 700},
            {250, 200, 600}
        };

        ProductSales ps = new ProductSales();

        // Print the data table (rows and columns)
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s", "");
        for (String q : quarters) {
            System.out.printf("%12s", q);
        }
        System.out.println();

        for (int i = 0; i < sales.length; i++) {
            System.out.printf("%-10s", years[i]);
            for (int j = 0; j < sales[i].length; j++) {
                System.out.printf("%12d", sales[i][j]);
            }
            System.out.println();
        }

        // Print the calculated results (average rounded to 0 decimals: 367)
        System.out.println("--------------------------------------------");
        System.out.println("Total sales:   " + ps.TotalSales(sales));
        System.out.printf("Average sales: %.0f%n", ps.AverageSales(sales));
        System.out.println("Maximum sale:  " + ps.MaxSale(sales));
        System.out.println("Minimum sale:  " + ps.MinSale(sales));
        System.out.println("--------------------------------------------");
    }
}
