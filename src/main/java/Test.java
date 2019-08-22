import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Movie movie;
        movieCreator create = new movieCreator();

        System.out.println("Please enter the key that provided by omdbAPI. \r\nIf you don't have you can have one from http://www.omdbapi.com/apikey.aspx here. ");
        String apiKey = input.next();
        Search.setApikey(apiKey); //Setting API key.

        System.out.println("Search movie by Title");
        String query = input.next();
        String omdbJson = Search.searchMovieByTitle(query); //Search by Title via user's query.

        List<String> moviesList = create.seperateMovies(omdbJson);

        for (int i = 0; i < create.moviesList.size(); i++) {
            movie = create.createMovie(moviesList.get(i));
            System.out.println("Poster -> " + movie.getPoster() + "\r\n" + "Title -> " + movie.getTitle()
                    + "\r\n" + "Director -> " + movie.getDirector() + "\r\n" + "Year -> " + movie.getYear()
                    + "\r\n" + "Ratings -> " + movie.getRatings() + "\r\n" + "Genre  -> " + movie.getGenre() + "\r\n--------");
        }
    }
}






