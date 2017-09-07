package com.example.admin.recyclerviewfirebase;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.recyclerviewfirebase.adapter.BookAdapter;
import com.example.admin.recyclerviewfirebase.injection.mainactivity.DaggerMainActivityComponent;
import com.example.admin.recyclerviewfirebase.model.Book;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MainActivity";
    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.rvBookList)
    RecyclerView rvBookList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
        updateFirebaseDB();

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onBookSaved(boolean isSaved) {
        Log.d(TAG, "onBookSaved: " + isSaved);
    }

    @Override
    public void updateFirebaseDB() {

        Book book = new Book("Hello World", "Saying Hello in different languages", 1);
        presenter.saveBookToFirebase(book);
        Book book1 = new Book("Hooray", "Saying Hello in different languages", 1);
        presenter.saveBookToFirebase(book1);
        Book book2 = new Book("Zinc", "Saying Hello in different languages", 1);
        presenter.saveBookToFirebase(book2);
        Book book3 = new Book("Estaban Coco", "Saying Hello in different languages", 1);
        presenter.saveBookToFirebase(book3);
        Book book4 = new Book("Summer Camp", "Saying Hello in different languages", 1);
        presenter.saveBookToFirebase(book4);
    }

    @Override
    public void loadRecyclerView(BookAdapter adapter) {
        if(rvBookList.getLayoutManager() == null){

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
            rvBookList.setLayoutManager(layoutManager);
            rvBookList.setItemAnimator(itemAnimator);
            rvBookList.addItemDecoration(dividerItemDecoration);

        }
        rvBookList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void doStuff(View view) {

        switch (view.getId()){

            case R.id.btnAddBook:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.new_book_item);
                dialog.setTitle("Add a new Book");



                Button btnDialog = (Button) dialog.findViewById(R.id.btnSaveBook);
                btnDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText etBookName = (EditText) dialog.findViewById(R.id.etBookName);
                        EditText etBookDescrition = (EditText) dialog.findViewById(R.id.etBookDescription);
                        EditText etBookPhoto = (EditText) dialog.findViewById(R.id.etBookPhotoInt);
                        final Book book = new Book(
                                etBookName.getText().toString(),
                                etBookDescrition.getText().toString(),
                                Integer.valueOf(etBookPhoto.getText().toString())
                        );
                        presenter.saveBookToFirebase(book);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.btnLoadRv:
                presenter.getBookFromFirebase();
                break;
        }
    }
}
