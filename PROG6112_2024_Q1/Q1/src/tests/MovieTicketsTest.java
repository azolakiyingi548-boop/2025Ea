package tests;

import app.MovieTickets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTicketsTest {

    private final MovieTickets mt = new MovieTickets();

    @Test
    void CalculateTotalSales_ReturnsExpectedTotalSales() {
        int[] napoleon = {3000, 1500, 1700};
        // 3000 + 1500 + 1700 = 6200
        assertEquals(6200, mt.TotalMovieSales(napoleon));
    }

    @Test
    void TopMovieSales_ReturnsTopMovie() {
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totals = {6200, 6300};
        assertEquals("Oppenheimer", mt.TopMovie(movies, totals));
    }
}
