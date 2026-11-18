package app;

// Interface exactly as given in the question paper
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTicketSales);
    String TopMovie(String[] movies, int[] totalSales);
}
