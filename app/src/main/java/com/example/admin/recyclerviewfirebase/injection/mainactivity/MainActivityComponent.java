package com.example.admin.recyclerviewfirebase.injection.mainactivity;

import com.example.admin.recyclerviewfirebase.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 8/23/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
