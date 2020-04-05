package com.example.quotesapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    List<String> quotes = null;
    Context context;

    public QuoteAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder quoteViewHolder, int i) {

        String[] colors = {"#3498db", "#e74c3c", "#8e44ad", "#95a5a6", "#27ae60"};
        final String quote = quotes.get(i);
        quoteViewHolder.txtQuote.setText(quote);

        //color multiple
        int color = i % colors.length;
        final int intColor = Color.parseColor(colors[color]);
        quoteViewHolder.quoteContainer.setBackgroundColor(intColor);

        quoteViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data",quote);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuote;
        LinearLayout quoteContainer;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);

            txtQuote = itemView.findViewById(R.id.txtQuote);
            quoteContainer = itemView.findViewById(R.id.quoteContainer);
        }
    }
}
