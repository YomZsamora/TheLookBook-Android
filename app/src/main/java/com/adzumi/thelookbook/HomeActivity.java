package com.adzumi.thelookbook;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView introductionTextView;
    private TextView whichBookTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        introductionTextView = (TextView) findViewById(R.id.introductionTextView);
        whichBookTextView = (TextView) findViewById(R.id.whichBookTextView);
        Typeface openSansFont = Typeface.createFromAsset(getAssets(), "fonts/opensans_light.ttf");
        introductionTextView.setTypeface(openSansFont);
        whichBookTextView.setTypeface(openSansFont);

//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
}
