package com.example.henri.bestmovie;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import com.example.henri.bestmovie.adapter.movieAdapter;
import com.example.henri.bestmovie.api.apiTMDB;
import com.example.henri.bestmovie.api.apiInterface;
import com.example.henri.bestmovie.model.Movie;
import com.example.henri.bestmovie.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheMovies extends AppCompatActivity {

    ImageView poster;
    TextView Judul, Rating, Release, Bahasa, Overview;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_movies);
        poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.tvTitle);
        Rating = (TextView)findViewById(R.id.tvRate);
        Release = (TextView)findViewById(R.id.tvDate);
        Bahasa = (TextView)findViewById(R.id.tvLang);
        Overview = (TextView)findViewById(R.id.tvOview);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(TheMovies.this)
                .load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath())
                .into(poster);
        Judul.setText(result.getTitle());
        Rating.setText(Double.toString(result.getVoteAverage()));
        Release.setText(result.getReleaseDate());
        Bahasa.setText(result.getOriginalLanguage());
        Overview.setText(result.getOverview());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_sort_setting, menu);

        return true;
    }

}