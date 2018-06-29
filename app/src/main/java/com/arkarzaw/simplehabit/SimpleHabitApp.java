package com.arkarzaw.simplehabit;

import android.app.Application;

import com.arkarzaw.simplehabit.datas.Models.SeriesModel;

public class SimpleHabitApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SeriesModel.initAppModel(getApplicationContext());
    }
}
