import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Search {

    private static String SEARCH_URL = "http://www.omdbapi.com/?s=title&apikey=userapikey";//Search by Title
    private static String SEARCH_URL_ID = "http://www.omdbapi.com/?i=id&apikey=userapikey";//Search by ID

    public static void setApikey(String apikey) {
        SEARCH_URL = SEARCH_URL.replaceAll("userapikey", apikey);
        SEARCH_URL_ID = SEARCH_URL_ID.replaceAll("userapikey", apikey);
    }

    public static String searchMovieByTitle(String title) {
        String requestURL = SEARCH_URL.replaceAll("title", title);
        return sendGetRequest(requestURL);
    }

    public static String searchMovieByID(String id) {
        String requestURL = SEARCH_URL_ID.replaceAll("id", id);
        return sendGetRequest(requestURL);
    }

    private static String sendGetRequest(String requestUrl) {
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*///*");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                response.append(line);
            }
            buffer.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Please anter a valid api key ! \r\n");
            e.printStackTrace();
        }
        return response.toString();
    }
}
