package com.adzumi.thelookbook.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adzumi.thelookbook.Constants;
import com.adzumi.thelookbook.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SavedBooksActivity extends AppCompatActivity {

    private DatabaseReference mBooksReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_books);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mBooksReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_SAVED_BOOKS)
                .child(uid);

//        setUpFirebaseAdapter();
    }
}
