package com.example.endpointsretrofit.movies_api;

import com.example.endpointsretrofit.json_mapper.Movie;
import com.example.endpointsretrofit.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
    //ROUTERS!!!! express.js
    @GET("movie/popular?api_key=eb7838fd57f27240510af0fa7f46d678&language=es-ES&page=1\n")
    Call<MovieResponse> getPopularMovies();


    //ROUTERS!!!! express.js
    @GET("search/movie?api_key=eb7838fd57f27240510af0fa7f46d678&language=es-ES&query=titanic&page=1\n")
    Call<MovieResponse> getMovie();

    //ROUTERS!!!! express.js
    @GET("movie/550?api_key=eb7838fd57f27240510af0fa7f46d678&language=es-ES\n")
    Call<Movie> getDetallesMovie();

}

