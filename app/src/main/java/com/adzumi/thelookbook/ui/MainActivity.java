package com.adzumi.thelookbook.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adzumi.thelookbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {

    @BindView(R.id.welcomeTextView) TextView welcomeTextView;
    @BindView(R.id.welcomeButton) Button mWelcomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface openSansFont = Typeface.createFromAsset(getAssets(), "fonts/opensans_bold.ttf");
        welcomeTextView.setTypeface(openSansFont);

        mWelcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
