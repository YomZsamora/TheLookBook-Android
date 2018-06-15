package com.adzumi.thelookbook.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.adapters.MyBooksAdapter;
import com.adzumi.thelookbook.models.Work;
import com.adzumi.thelookbook.services.GoodReads;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class CurrentBookActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private MyBooksAdapter mAdapter;
    @BindView(R.id.myBooksRecyclerView) RecyclerView mBooksRecyclerView;
    public List<Work> mBooks = new ArrayList<>();

    @BindView(R.id.searchQueryTextView) TextView mSearchQueryTextView;
//    @BindView(R.id.readWhatTextView) TextView mReadWhatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_book);
        ButterKnife.bind(this);

        Typeface openSansFontLight = Typeface.createFromAsset(getAssets(), "fonts/opensans_light.ttf");
//        mBookNameTextView.setTypeface(openSansFontLight);

        Typeface openSansFont = Typeface.createFromAsset(getAssets(), "fonts/opensans_bold.ttf");
//        mBookNameTextView.setTypeface(openSansFont);

        Intent intent = getIntent();
        String currentBook = intent.getStringExtra("currentBook");
        mSearchQueryTextView.setText("Search Results For " + currentBook);
        getBooks(currentBook);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    private void getBooks(String searchBook) {
        final GoodReads bookService = new GoodReads();
        bookService.findBooks(searchBook, new Callback() {
            @Override
            public void onFailure(Call call, java.io.IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws java.io.IOException {
                mBooks = bookService.bookResults(response);

                CurrentBookActivity.this.runOnUiThread(() -> {
                    mAdapter = new MyBooksAdapter(getApplicationContext(), mBooks);

                    mBooksRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(CurrentBookActivity.this);
                    mBooksRecyclerView.setLayoutManager(layoutManager);
                    mBooksRecyclerView.setHasFixedSize(true);
                });
            }
        });
    }
}
