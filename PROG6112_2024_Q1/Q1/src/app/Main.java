package app;

public class Main {
    public static void main(String[] args) {

        // Single-dimensional arrays: movie names and month headings
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"JAN", "FEB", "MAR"};

        // Two-dimensional array: rows = movies, columns = months
        int[][] sales = {
            {3000, 1500, 1700},   // Napoleon
            {3500, 1200, 1600}    // Oppenheimer
        };

        MovieTickets mt = new MovieTickets();

        // Single-dimensional array to hold each movie's total
        int[] totals = new int[movies.length];
        for (int i = 0; i < movies.length; i++) {
            totals[i] = mt.TotalMovieSales(sales[i]);   // sales[i] = one row
        }

        // Print the heading and month columns
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();
        System.out.printf("%-15s", "");
        for (String month : months) {
            System.out.printf("%10s", month);
        }
        System.out.println();
        System.out.println("-----------------------------------------------");

        // Print each movie's row
        for (int i = 0; i < movies.length; i++) {
            System.out.printf("%-15s", movies[i]);
            for (int j = 0; j < sales[i].length; j++) {
                System.out.printf("%10d", sales[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Print the totals and the top movie
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Total movie ticket sales for " + movies[i] + " " + totals[i]);
        }
        System.out.println();
        System.out.println("Top performing movie: " + mt.TopMovie(movies, totals));
    }
}
