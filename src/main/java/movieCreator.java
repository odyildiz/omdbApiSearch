import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class movieCreator {
    Movie movie;
    List<String> moviesList = new ArrayList<String>();
    Search search = new Search();

    public Movie createMovie(String moviesss) {
        //Creating a movie object.
        movie = new Movie();
        try {
            String title = JsonPath.parse(moviesss).read("$.Title");
            movie.setTitle(title);
            String year = JsonPath.parse(moviesss).read("$.Year");
            movie.setYear(year);
            String rated = JsonPath.parse(moviesss).read("$.Rated");
            movie.setRated(rated);
            String released = JsonPath.parse(moviesss).read("$.Released");
            movie.setReleased(released);
            String runTime = JsonPath.parse(moviesss).read("$.Runtime");
            movie.setRunTime(runTime);
            String genre = JsonPath.parse(moviesss).read("$.Genre");
            movie.setGenre(genre);
            String director = JsonPath.parse(moviesss).read("$.Director");
            movie.setDirector(director);
            String writer = JsonPath.parse(moviesss).read("$.Writer");
            movie.setWriter(writer);
            String actors = JsonPath.parse(moviesss).read("$.Actors");
            movie.setActors(actors);
            String plot = JsonPath.parse(moviesss).read("$.Plot");
            movie.setPlot(plot);
            String language = JsonPath.parse(moviesss).read("$.Language");
            movie.setLanguage(language);
            String country = JsonPath.parse(moviesss).read("$.Country");
            movie.setCountry(country);
            String awards = JsonPath.parse(moviesss).read("$.Awards");
            movie.setAwards(awards);
            String poster = JsonPath.parse(moviesss).read("$.Poster");
            movie.setPoster(poster);
            JSONArray ratings = JsonPath.parse(moviesss).read("$..Ratings");
            movie.setRatings(ratings);
            String metascore = JsonPath.parse(moviesss).read("$.Metascore");
            movie.setMetascore(metascore);
            String imdbrating = JsonPath.parse(moviesss).read("$.imdbRating");
            movie.setImdbRating(imdbrating);
            String imdbVotes = JsonPath.parse(moviesss).read("$.imdbVotes");
            movie.setImdbVotes(imdbVotes);
            String imdbID = JsonPath.parse(moviesss).read("$.imdbID");
            movie.setImdbID(imdbID);
            String type = JsonPath.parse(moviesss).read("$.Type");
            movie.setType(type);
            String DVD = JsonPath.parse(moviesss).read("$.DVD");
            movie.setDVD(DVD);
            String boxOffice = JsonPath.parse(moviesss).read("$.BoxOffice");
            movie.setBoxOffice(boxOffice);
            String production = JsonPath.parse(moviesss).read("$.Production");
            movie.setProduction(production);
            String website = JsonPath.parse(moviesss).read("$.Website");
            movie.setWebsite(website);
        } catch (com.jayway.jsonpath.PathNotFoundException e) {
        }
        return movie;
    }

    public List<String> seperateMovies(String moviesInfo) {
        // Seperating every movie that coming from query by their ID.
        List<String> IDs = JsonPath.parse(moviesInfo).read("$..imdbID");

        for (int i = 0; i < IDs.size(); i++) {
            String movieList = search.searchMovieByID(IDs.get(i));
            this.moviesList.add(movieList);
        }
        return this.moviesList;
    }
}
