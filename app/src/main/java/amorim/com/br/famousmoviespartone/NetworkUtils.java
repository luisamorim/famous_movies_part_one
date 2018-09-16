package amorim.com.br.famousmoviespartone;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by luisamorim on 9/16/18.
 */

public class NetworkUtils {

    final static String API_KEY = "INSERT_YOUR_API_KEY_HERE";
    final static String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key="+API_KEY;

    public static String fetchMovies(String url){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
