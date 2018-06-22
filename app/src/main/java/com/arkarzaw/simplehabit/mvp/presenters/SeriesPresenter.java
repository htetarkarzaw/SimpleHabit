package com.arkarzaw.simplehabit.mvp.presenters;

import android.support.design.widget.Snackbar;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SeriesPresenter extends BasePresenter<SeriesView> implements ItemClickListener{

    public SeriesPresenter(SeriesView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onActivityCreated() {
        super.onActivityCreated();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        SeriesModel.getInstance().startLoadingSimpleHabit();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ErrorInvokingApi(RestApiEvent.ErrorInvokingAPIEvent event){
        mView.displayErrorMsg(event.getErrorMsg());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataReady(RestApiEvent.DataReadyEvent event){
        if(event.getAllList()==null){
            mView.displayErrorMsg("no Data");
        }else {
            mView.displayPrograms(event.getAllList());
        }
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
