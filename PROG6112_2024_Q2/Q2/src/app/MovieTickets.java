package app;

public class MovieTickets implements IMovieTickets {

    private static final double VAT_RATE = 0.14;   // 14% VAT

    // Tickets x price, then add 14% VAT (rounded to 2 decimals)
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        double total = subtotal + (subtotal * VAT_RATE);
        return Math.round(total * 100.0) / 100.0;
    }

    // Returns true only if ALL the validation rules pass
    @Override
    public boolean ValidateData(MovieTicketData data) {
        boolean nameOk = data.getMovieName() != null && !data.getMovieName().trim().isEmpty();
        boolean priceOk = data.getTicketPrice() > 0;
        boolean ticketsOk = data.getNumberOfTickets() > 0;
        return nameOk && priceOk && ticketsOk;
    }
}
