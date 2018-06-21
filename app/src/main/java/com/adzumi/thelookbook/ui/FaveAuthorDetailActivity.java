package com.adzumi.thelookbook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adzumi.thelookbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FaveAuthorDetailActivity extends AppCompatActivity {

    @BindView(R.id.myFaveAuthorName) TextView myFavoriteAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fave_author_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String favoriteAuthor = intent.getStringExtra("author");
        myFavoriteAuthor.setText(favoriteAuthor);
    }
}
