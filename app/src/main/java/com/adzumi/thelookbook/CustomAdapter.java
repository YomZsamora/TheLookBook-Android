package com.adzumi.thelookbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {


    public CustomAdapter(Context context, String[] books) {
        super(context, R.layout.bookslist, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater booksInflater = LayoutInflater.from(getContext());
        View customView = booksInflater.inflate(R.layout.bookslist, parent, false);

        String bookItem = String.valueOf(getItem(position));
        TextView author = (TextView) customView.findViewById(R.id.authorName);
        ImageView imageBook = (ImageView) customView.findViewById(R.id.bookImage);

        author.setText(bookItem);
        imageBook.setImageResource(R.drawable.theshining);
        return customView;
    }
}
