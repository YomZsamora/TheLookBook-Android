package com.adzumi.thelookbook.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.adapters.BookPagerAdapter;
import com.adzumi.thelookbook.models.Work.Work;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private BookPagerAdapter adapterViewPager;
    ArrayList<Work> mWork = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);

        mWork = Parcels.unwrap(getIntent().getParcelableExtra("work"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new BookPagerAdapter(getSupportFragmentManager(), mWork);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
