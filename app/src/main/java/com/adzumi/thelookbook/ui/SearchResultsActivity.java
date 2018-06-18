package com.adzumi.thelookbook.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;

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


public class SearchResultsActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private MyBooksAdapter mAdapter;
    @BindView(R.id.myBooksRecyclerView) RecyclerView mBooksRecyclerView;
    public List<Work> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
//        handleIntent(getIntent());
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        getBooks(query);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search Author / Book ...");
        return true;
    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        handleIntent(intent);
//    }
//
//    private void handleIntent(Intent intent) {
//
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            String query = intent.getStringExtra(SearchManager.QUERY);
//            getBooks(query);
//        }
//    }

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

                SearchResultsActivity.this.runOnUiThread(() -> {
                    mAdapter = new MyBooksAdapter(getApplicationContext(), mBooks);

                    mBooksRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager
                            = new LinearLayoutManager(SearchResultsActivity.this);
                    mBooksRecyclerView.setLayoutManager(layoutManager);
                    mBooksRecyclerView.setHasFixedSize(true);
                });
            }
        });
    }
}
