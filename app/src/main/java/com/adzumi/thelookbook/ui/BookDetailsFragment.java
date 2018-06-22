package com.adzumi.thelookbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.models.Work;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailsFragment extends Fragment {

    @BindView(R.id.bookImageDetail) ImageView mBookImageDetail;
    @BindView(R.id.bookTitleDetail) TextView mBookTitleDetail;
    @BindView(R.id.bookDescriptionDetail) TextView mBookDescriptionDetail;
    @BindView(R.id.bookAuthorName) TextView mBookAuthorName;

    private Work mWork;

    public static BookDetailsFragment newInstance(Work work) {
        BookDetailsFragment bookDetailFragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("work", Parcels.wrap(work));
        bookDetailFragment.setArguments(args);
        return bookDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWork = Parcels.unwrap(getArguments().getParcelable("work"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mWork.getBestBook().getImageUrl()).into(mBookImageDetail);

        mBookTitleDetail.setText(mWork.getBestBook().getTitle());

        return view;
    }
}
