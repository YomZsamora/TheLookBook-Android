package com.adzumi.thelookbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.models.Work.Work;
import com.adzumi.thelookbook.ui.BookDetailsActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Work> mWork;
    private Context mContext;

    public BookAdapter(Context context,List<Work> mWork){
        this.mContext = context;
        this.mWork = mWork;
    }

    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final View mView;
        @BindView(R.id.bookImageView) ImageView mBookImageView;
        @BindView(R.id.bookNameTextView) TextView mBookNameTextView;
        @BindView(R.id.authorTextView) TextView mAuthorTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        BookViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, BookDetailsActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("work", Parcels.wrap(mWork));
            mContext.startActivity(intent);
        }

        public void bindBooks(Work work) {
            mBookNameTextView.setText(work.getBestBook().getTitle());
            mAuthorTextView.setText("By " + work.getBestBook().getAuthor().getName());
            mRatingTextView.setText("Rating: " + work.getAverageRating() + "/5");

            if (!(work.getBestBook().getSmallImageUrl().isEmpty())) {
                Picasso.with(mContext).load(work.getBestBook().getSmallImageUrl())
                        .fit()
                        .centerCrop()
                        .placeholder(R.drawable.goodreads)
                        .into(mBookImageView);
            }
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_book_item, parent, false);
        return new BookViewHolder(view);
    }

    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bindBooks(mWork.get(position));
    }

    @Override
    public int getItemCount() {
        return mWork.size();
    }
}
