package com.example.admin.recyclerviewfirebase;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.admin.recyclerviewfirebase.adapter.BookAdapter;
import com.example.admin.recyclerviewfirebase.model.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/23/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivityPresenter";

    MainActivityContract.View view;
    FirebaseDatabase database;
    DatabaseReference bookReference;
    Context context;
    BookAdapter adapter;

    @Override
    public void init() {
        database = FirebaseDatabase.getInstance();
        bookReference = database.getReference("books");
    }

    public void attachView(MainActivityContract.View view) {
        init();
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void saveBookToFirebase(Book book) {
        Log.d(TAG, "saveDataFirebase: " + book.toString());
        //bookReference.push().setValue(book);
        bookReference.child(book.getName()).setValue(book);
        view.onBookSaved(true);
    }

    @Override
    public void getBookFromFirebase() {


        final List<Book> bookList = new ArrayList<>();
        bookReference = database.getReference("books");


        bookReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Book book = snapshot.getValue(Book.class);
                    bookList.add(book);
                }

                initRecyclerView(bookList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void initRecyclerView(List<Book> bookList) {
        adapter = new BookAdapter(bookList);
        view.loadRecyclerView(adapter);
    }
}
