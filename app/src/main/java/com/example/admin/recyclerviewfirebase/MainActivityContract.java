package com.example.admin.recyclerviewfirebase;

import android.content.Context;

import com.example.admin.recyclerviewfirebase.adapter.BookAdapter;
import com.example.admin.recyclerviewfirebase.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/23/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void onBookSaved(boolean isSaved);
        void updateFirebaseDB();
        void loadRecyclerView(BookAdapter adapter);

    }

    interface Presenter extends BasePresenter<View>{
        void saveBookToFirebase(Book book);
        void getBookFromFirebase();
        void setContext(Context context);
        void initRecyclerView(List<Book> bookList);
        void init();
    }
}
