package app;

public class ProductSales implements IProductSales {

    private static final int SALES_LIMIT = 500;   // retailer's success limit

    // "Loaded from memory": rows = years, columns = Microphone, Speakers, Mixing Desk
    private final int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    // Add up every value
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    // Count how many individual sales are above the limit
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Count how many individual sales are below the limit
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Years processed = number of rows in the array
    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    // Total divided by how many values there are
    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        return (double) GetTotalSales() / count;
    }
}
