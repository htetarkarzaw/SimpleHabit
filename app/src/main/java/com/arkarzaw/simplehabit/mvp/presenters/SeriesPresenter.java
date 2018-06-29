package com.arkarzaw.simplehabit.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.mvp.views.SeriesView;

import java.util.List;

public class SeriesPresenter extends BasePresenter<SeriesView> implements ItemClickListener{

    private MutableLiveData<List<BaseVO>> mutableLiveData;

    @Override
    public void initPresenter(SeriesView view) {
        super.initPresenter(view);
        mutableLiveData = new MutableLiveData<>();
        SeriesModel.getInstance().startLoadingDataWithRx(mutableLiveData,mErrorLD);
    }

    public LiveData<List<BaseVO>> getMBaseVO() {
        return mutableLiveData;
    }

    @Override
    public void onCurrentItemClick() {
        mView.onLaunchCurrentDetail();
    }

    @Override
    public void onCategoryItemClick(String categoryId, String programId) {
        mView.onLaunchDetailProgram(categoryId,programId);
    }
}
