package com.adzumi.thelookbook.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.models.Work;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBooksAdapter
        extends RecyclerView.Adapter<MyBooksAdapter.BookViewHolder> {
    private List<Work> mBooks = new ArrayList<>();
    private Context mContext;

    public MyBooksAdapter(Context context, List<Work> myBooks) {
        mContext = context;
        mBooks = myBooks;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bindBooks(mBooks.get(position));
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_book_item, parent, false);
        BookViewHolder viewHolder = new BookViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bookImageView) ImageView mBookImageView;
        @BindView(R.id.bookNameTextView) TextView mBookNameTextView;
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBooks(Work work) {
            mBookNameTextView.setText(work.getBestBook().getTitle());
            mAuthorTextView.setText(work.getBestBook().getAuthor().getName());
            mRatingTextView.setText(work.getAverageRating());

            if (!(work.getBestBook().getSmallImageUrl().isEmpty())) {
                Picasso.with(mContext).load(work.getBestBook().getSmallImageUrl())
                        .fit()
                        .centerCrop()
                        .placeholder(R.drawable.goodreads)
                        .into(mBookImageView);
            }
        }
    }
}

