package tests;

import app.MovieTicketData;
import app.MovieTickets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTicketsTest {

    private final MovieTickets mt = new MovieTickets();

    @Test
    void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // 3 tickets x R100 = R300, plus 14% VAT = R342
        assertEquals(342.0, mt.CalculateTotalTicketPrice(3, 100), 0.001);
    }

    @Test
    void ValidateData_EmptyMovieName_ReturnsFalse() {
        MovieTicketData data = new MovieTicketData("", 3, 100);
        assertFalse(mt.ValidateData(data));
    }

    @Test
    void ValidateData_ValidData_ReturnsTrue() {
        MovieTicketData data = new MovieTicketData("Napoleon", 3, 100);
        assertTrue(mt.ValidateData(data));
    }
}
