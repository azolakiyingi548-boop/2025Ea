package app;

public class MovieTickets implements IMovieTickets {

    // Adds up the sales of ONE movie (one row of the table)
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int sales : movieTicketSales) {
            total += sales;
        }
        return total;
    }

    // Finds the highest total and returns the matching movie name
    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int topIndex = 0;                         // assume the first movie is the best
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;                     // found a better one
            }
        }
        return movies[topIndex];
    }
}
