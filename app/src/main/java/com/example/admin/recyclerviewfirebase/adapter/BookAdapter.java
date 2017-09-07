package com.example.admin.recyclerviewfirebase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.recyclerviewfirebase.R;
import com.example.admin.recyclerviewfirebase.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/23/2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> books = new ArrayList<>();

    public BookAdapter(List<Book> bookList) {
        this.books = bookList;
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = books.get(position);

        holder.tvBookName.setText(book.getName());
        holder.tvBookDescription.setText(book.getDescription());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBookName, tvBookDescription;
        ImageView ivBookPhoto;

        public ViewHolder(View itemView) {
            super(itemView);

            tvBookName = (TextView) itemView.findViewById(R.id.tvBookName);
            tvBookDescription= (TextView) itemView.findViewById(R.id.tvBookDescription);
            ivBookPhoto = (ImageView) itemView.findViewById(R.id.ivBookPhoto);

        }
    }
}
