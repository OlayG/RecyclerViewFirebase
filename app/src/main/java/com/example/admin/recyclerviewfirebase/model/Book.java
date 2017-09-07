package com.example.admin.recyclerviewfirebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Admin on 8/23/2017.
 */

@IgnoreExtraProperties
public class Book {

    String name, description;
    int photo;

    public Book() {
    }

    public Book(String name, String description, int photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                '}' + '\n';
    }
}
