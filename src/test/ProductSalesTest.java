package test;

import app.ProductSales;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSalesTest {

    private final ProductSales ps = new ProductSales();

    @Test
    void GetSalesOverLimit_ReturnsNumberOfSales() {
        // Only 700 and 600 are above 500
        assertEquals(2, ps.GetSalesOverLimit());
    }

    @Test
    void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // 300, 150, 250, 200 are below 500
        assertEquals(4, ps.GetSalesUnderLimit());
    }
}
