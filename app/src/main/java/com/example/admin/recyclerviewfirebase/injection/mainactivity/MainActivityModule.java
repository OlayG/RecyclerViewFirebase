package com.example.admin.recyclerviewfirebase.injection.mainactivity;

import com.example.admin.recyclerviewfirebase.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 8/23/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter() {
        return new MainActivityPresenter();
    }
}
