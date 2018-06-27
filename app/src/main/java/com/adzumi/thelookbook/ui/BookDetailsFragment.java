package com.adzumi.thelookbook.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.models.Work.Work;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailsFragment extends Fragment {

    @BindView(R.id.bookImageDetail) ImageView mBookImageDetail;
    @BindView(R.id.bookTitleDetail) TextView mBookTitleDetail;
    @BindView(R.id.bookDescriptionDetail) TextView mBookDescriptionDetail;
    @BindView(R.id.bookAuthorName) TextView mBookAuthorName;
    @BindView(R.id.ratingBar2) RatingBar mBookRatingBar;
    @BindView(R.id.rateTextView) TextView mRateTextView;
    @BindView(R.id.ratingsTextView) TextView mRatingsTextView;

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

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        double bookRatings = Double.parseDouble(mWork.getRatingsCount().getText());
        Picasso.with(view.getContext()).load(mWork.getBestBook().getImageUrl()).fit().into(mBookImageDetail);
        mBookTitleDetail.setText(mWork.getBestBook().getTitle());
        mBookAuthorName.setText("By " + mWork.getBestBook().getAuthor().getName());
        mBookRatingBar.setRating(Float.valueOf(mWork.getAverageRating()));
        mRateTextView.setText(mWork.getAverageRating());
        mRatingsTextView.setText("(" + formatter.format(bookRatings) + " Ratings)");

        return view;
    }
}
