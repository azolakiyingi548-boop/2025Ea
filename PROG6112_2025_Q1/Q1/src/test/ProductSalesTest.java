package test;

import app.ProductSales;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSalesTest {

    // Same data as the question
    private final int[][] data = {{300, 150, 700}, {250, 200, 600}};
    private final ProductSales ps = new ProductSales();

    @Test
    void CalculateTotalSales_ReturnsTotalSales() {
        assertEquals(2200, ps.TotalSales(data));
    }

    @Test
    void AverageSales_ReturnsAverageProductSales() {
        // 2200 / 6 = 366.666..., so allow a tiny difference (delta)
        assertEquals(366.67, ps.AverageSales(data), 0.01);
    }
}
