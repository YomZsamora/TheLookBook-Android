package com.adzumi.thelookbook;

import com.adzumi.thelookbook.models.Work;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.Call;
import okhttp3.Callback;

import android.util.Log;
import android.view.Menu;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.introductionTextView) TextView introductionTextView;
    @BindView(R.id.whichBookTextView) TextView whichBookTextView;
    @BindView(R.id.winnersTextView) TextView mWinnersTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.booksTextView) TextView mBooksTextView;
    @BindView(R.id.searchBookButton) Button mSearchBookButton;
    @BindView(R.id.whichBookEditText) EditText mWhichBookEditText;

    private int[] booksImages = new int[] {R.drawable.theshining, R.drawable.it,
            R.drawable.thestand, R.drawable.thegunslinger, R.drawable.goodreads, R.drawable.misery,
            R.drawable.petsematary, R.drawable.underthedome, R.drawable.thegreenmile, R.drawable.cujo,
            R.drawable.doctorsleep, R.drawable.drawingofthethree, R.drawable.goodreads};

    private String[] books = new String[] {"The Shining", "IT: PennyWise the Clown",
            "The Stand", "The Gunslinger", "Carrie", "Misery",
            "Pet Sematary", "Under the Dome", "The Green Mile", "Cujo",
            "Doctor Sleep", "The Drawing of the Three", "Cell"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Typeface openSansFontLight = Typeface.createFromAsset(getAssets(), "fonts/opensans_light.ttf");
        introductionTextView.setTypeface(openSansFontLight);
        whichBookTextView.setTypeface(openSansFontLight);

        Typeface openSansFontItalic = Typeface.createFromAsset(getAssets(), "fonts/opensans_italic.ttf");
        mWinnersTextView.setTypeface(openSansFontItalic);

        Typeface openSansFontSemiBold = Typeface.createFromAsset(getAssets(), "fonts/opensans_semibold.ttf");
        mBooksTextView.setTypeface(openSansFontSemiBold);

        ArrayAdapter adapter = new CustomAdapter(this, books);
        mListView.setAdapter(adapter);

        mBooksTextView.setText("Here's a list of some of Stephen King's Books: ");

        mSearchBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentBook = mWhichBookEditText.getText().toString();
                Intent intent = new Intent(HomeActivity.this, CurrentBookActivity.class);
                intent.putExtra("currentBook", currentBook);
                startActivity(intent);
            }
        });

//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
}
