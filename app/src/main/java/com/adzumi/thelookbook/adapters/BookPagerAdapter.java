package com.adzumi.thelookbook.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adzumi.thelookbook.models.Work.Work;
import com.adzumi.thelookbook.ui.BookDetailsFragment;

import java.util.ArrayList;

public class BookPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Work> mWork;

    public BookPagerAdapter(FragmentManager fm, ArrayList<Work> work) {
        super(fm);
        mWork = work;
    }

    @Override
    public Fragment getItem(int position) {
        return BookDetailsFragment.newInstance(mWork.get(position));
    }

    @Override
    public int getCount() {
        return mWork.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mWork.get(position).getBestBook().getTitle();
    }
}
