package com.adzumi.thelookbook.ui;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.adzumi.thelookbook.Constants;
import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.adapters.CustomAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mSearchedAuthorReference;

    @BindView(R.id.introductionTextView) TextView introductionTextView;
    @BindView(R.id.winnersTextView) TextView mWinnersTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.booksTextView) TextView mBooksTextView;
    @BindView(R.id.searchAuthorEditText) EditText mSearchAuthorEditText;
    @BindView(R.id.searchAuthorButton) Button mSearchAuthorButton;

    public static final String TAG = HomeActivity.class.getSimpleName();

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
        mSearchedAuthorReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_BOOK);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Typeface openSansFontLight = Typeface.createFromAsset(getAssets(), "fonts/opensans_light.ttf");
        introductionTextView.setTypeface(openSansFontLight);

        Typeface openSansFontItalic = Typeface.createFromAsset(getAssets(), "fonts/opensans_italic.ttf");
        mWinnersTextView.setTypeface(openSansFontItalic);

        Typeface openSansFontSemiBold = Typeface.createFromAsset(getAssets(), "fonts/opensans_semibold.ttf");
        mBooksTextView.setTypeface(openSansFontSemiBold);

        ArrayAdapter adapter = new CustomAdapter(this, books);
        mListView.setAdapter(adapter);

        mSearchAuthorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mSearchAuthorButton){
            String author = mSearchAuthorEditText.getText().toString();
            saveAuthorToFirebase(author);
            Intent intent = new Intent(HomeActivity.this, FaveAuthorDetailActivity.class);
            intent.putExtra("author", author);
            startActivity(intent);
        }
    }

    public void saveAuthorToFirebase(String author) {
        mSearchedAuthorReference.setValue(author);
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.e("onQueryTextChange", "called");
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(HomeActivity.this, SearchResultsActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
                return false;
            }
        });
        return true;
    }
}
