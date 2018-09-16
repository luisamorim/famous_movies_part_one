package amorim.com.br.famousmoviespartone;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.NetworkInterface;
import java.net.URL;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    TextView mDisplayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayResult = (TextView) findViewById(R.id.tv_results);

        makeMoviesQuery();
    }

    public void makeMoviesQuery(){
        new FetchMoviesTask().execute(NetworkUtils.BASE_URL);
    }

    public class FetchMoviesTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return NetworkUtils.fetchMovies(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null && !s.equals("")){
                mDisplayResult.setText(s);
            }
        }
    }
}
