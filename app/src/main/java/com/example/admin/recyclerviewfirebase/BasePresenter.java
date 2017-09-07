package com.example.admin.recyclerviewfirebase;

/**
 * Created by Admin on 8/23/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
