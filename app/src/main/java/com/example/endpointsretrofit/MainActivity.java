package com.example.endpointsretrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.endpointsretrofit.json_mapper.Movie;
import com.example.endpointsretrofit.json_mapper.MovieResponse;
import com.example.endpointsretrofit.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies();
                call.enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful()) {
                            List<Movie> movies = response.body().getResults();
                            // Procesa y muestra las películas aquí
                            for (Movie myMovie:movies){
                                Toast.makeText(MainActivity.this, "Movie: "+ myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                    }
                });
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<MovieResponse> call = RetrofitClient.getInstance().getMovie();


                call.enqueue(new Callback<MovieResponse>() {


                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful()) {
                            List<Movie> movies = response.body().getResults();
                            // Procesa y muestra las películas aquí
                            for (Movie myMovie:movies){
                                Toast.makeText(MainActivity.this, "Movie: "+ myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Movie> call = RetrofitClient.getInstance().getDetallesMovie();

                call.enqueue(new Callback<Movie>() {


                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if (response.isSuccessful()) {
                            String movies = response.body().getOverview();

                            // Procesa y muestra las películas aquí

                                Toast.makeText(MainActivity.this, "Sinopsis: "+ movies, Toast.LENGTH_SHORT).show();
                            }
                        }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                    }
                });
            }
        });
    }
}