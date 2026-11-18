package app;

// Implements the interface: one separate method per calculation
public class ProductSales implements IProduct {

    // Adds up every value in the 2D array
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] row : productSales) {      // each row = one year
            for (int sale : row) {            // each value = one quarter
                total += sale;
            }
        }
        return total;
    }

    // Total divided by the number of values (6 in this case)
    @Override
    public double AverageSales(int[][] productSales) {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        if (count == 0) {
            return 0;                         // avoid dividing by zero
        }
        return (double) TotalSales(productSales) / count;
    }

    // Start with the first value, replace it whenever something bigger is found
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    // Same idea as max, but looking for smaller values
    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}
