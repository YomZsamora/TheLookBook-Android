package com.adzumi.thelookbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentBookActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.currentBookTextView) TextView mCurrentBookTextView;
    @BindView(R.id.readWhatTextView) TextView mReadWhatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_book);
        ButterKnife.bind(this);

        Typeface openSansFontLight = Typeface.createFromAsset(getAssets(), "fonts/opensans_light.ttf");
        mReadWhatTextView.setTypeface(openSansFontLight);

        Typeface openSansFont = Typeface.createFromAsset(getAssets(), "fonts/opensans_bold.ttf");
        mCurrentBookTextView.setTypeface(openSansFont);

        Intent intent = getIntent();
        String currentBook = intent.getStringExtra("currentBook");
        mCurrentBookTextView.setText("" + currentBook + "");
        getBooks("stephen king");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    private void getBooks(String searchBook) {
        final GoodReads findBook = new GoodReads();
        findBook.findBooks(searchBook, new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, java.io.IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) {

                try {
                    String xmlData = response.body().string();
                    if (response.isSuccessful()) {
                        org.json.JSONObject responseJson = org.json.XML.toJSONObject(xmlData);
                        org.json.JSONArray jsonArray = responseJson.getJSONObject("GoodreadsResponse")
                        .getJSONObject("search")
                        .getJSONObject("results")
                        .getJSONArray("work");

                        android.util.Log.v(TAG, jsonArray.toString());
                    }
                } catch (java.io.IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
