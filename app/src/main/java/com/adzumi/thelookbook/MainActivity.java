package com.adzumi.thelookbook;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        Typeface openSansFont = Typeface.createFromAsset(getAssets(), "fonts/opensans_bold.ttf");
        welcomeTextView.setTypeface(openSansFont);
    }
}
