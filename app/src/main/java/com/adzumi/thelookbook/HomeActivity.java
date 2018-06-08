package com.adzumi.thelookbook;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.view.MenuInflater;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.introductionTextView) TextView introductionTextView;
    @BindView(R.id.whichBookTextView) TextView whichBookTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

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
