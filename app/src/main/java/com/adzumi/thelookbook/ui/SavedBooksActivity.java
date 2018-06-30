package com.adzumi.thelookbook.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adzumi.thelookbook.Constants;
import com.adzumi.thelookbook.R;
import com.adzumi.thelookbook.adapters.FirebaseBookViewHolder;
import com.adzumi.thelookbook.models.Work.Work;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedBooksActivity extends AppCompatActivity {

    private DatabaseReference mSavedBookReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @BindView(R.id.myBooksRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mSavedBookReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_BOOKS)
                .child(uid);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Work, FirebaseBookViewHolder>
                (Work.class, R.layout.my_book_item, FirebaseBookViewHolder.class,
                        mSavedBookReference) {

            @Override
            protected void populateViewHolder(FirebaseBookViewHolder viewHolder,
                                              Work model, int position) {
                viewHolder.bindBooks(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
