package com.amishgarg.wartube.Activity;

import android.util.Log;

import com.amishgarg.wartube.Model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FirebaseQueryLiveData extends LiveData<DataSnapshot> {

    private static final String LOG_TAG = "FirebaseQueryLiveData";

    private final Query query;
    private final MyValueEventListener listener = new MyValueEventListener();

    MutableLiveData<List<Post>> posts = new MutableLiveData<>();
    List<Post> postList = new ArrayList<>();

    public FirebaseQueryLiveData(Query query) {
        this.query = query;
    }

    public FirebaseQueryLiveData(DatabaseReference ref) {
        this.query = ref;
    }

    public MutableLiveData<List<Post>> getPosts(){
        return posts;
    }

    @Override
    protected void onActive() {
        Log.d(LOG_TAG, "onActive");
        query.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        Log.d(LOG_TAG, "onInactive");
        query.removeEventListener(listener);
    }

    private class MyValueEventListener implements ValueEventListener {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            setValue(dataSnapshot);
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren())
            {
                if(postSnapshot != null)
                {
                    Log.d("FirebaseLiveData", postSnapshot.getValue(Post.class).getTimestamp().toString());
                    postList.add(postSnapshot.getValue(Post.class));

                }
                else
                {
                    Log.e(LOG_TAG, "NULL POSTSNAP");
                }
            }
            posts.setValue(postList);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.e(LOG_TAG, "Can't listen to query " + query, databaseError.toException());
        }
    }
}


