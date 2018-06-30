package com.adzumi.thelookbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adzumi.thelookbook.Constants;
import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.models.Work.Work;
import com.adzumi.thelookbook.ui.BookDetailsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirebaseBookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.bookImageView) ImageView mBookImageView;
    @BindView(R.id.bookNameTextView) TextView mBookNameTextView;
    @BindView(R.id.authorTextView) TextView mAuthorTextView;
    @BindView(R.id.ratingTextView) TextView mRatingTextView;
    @BindView(R.id.ratingsTextView) TextView mRatingsTextView;
    @BindView(R.id.ratingBar2) RatingBar mBookRatingBar;

    View mView;
    Context mContext;

    public FirebaseBookViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        ButterKnife.bind(this, mView);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindBooks(Work work) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        double bookRatings = Double.parseDouble(work.getRatingsCount().getText());
        mBookNameTextView.setText(work.getBestBook().getTitle());
        mAuthorTextView.setText("By " + work.getBestBook().getAuthor().getName());
        mRatingTextView.setText(work.getAverageRating() + "/5");
        mRatingsTextView.setText(formatter.format(bookRatings) + " Ratings");
        mBookRatingBar.setRating(Float.valueOf(work.getAverageRating()));


        if (!(work.getBestBook().getSmallImageUrl().isEmpty())) {
            Picasso.with(mContext).load(work.getBestBook().getSmallImageUrl())
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.goodreads)
                    .into(mBookImageView);
        }
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Work> books = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SAVED_BOOKS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    books.add(snapshot.getValue(Work.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, BookDetailsActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("books", Parcels.wrap(books));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
