package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView quoteList = findViewById(R.id.quoteList);
        quoteList.setLayoutManager(new LinearLayoutManager(this));

        quoteList.setAdapter(new QuoteAdapter(getQuotes(), this));
    }

    private List<String> getQuotes() {
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes.txt")));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                quotes.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return quotes;
    }
}
