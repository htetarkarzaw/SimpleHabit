package com.arkarzaw.simplehabit.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.adapters.SeriesAdapter;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewSeriesFragment extends Fragment {

    @BindView(R.id.rcView)
    RecyclerView rcView;
    SeriesAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_new, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }

    private void setUp() {
        rcView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new SeriesAdapter(getContext());
        rcView.setAdapter(adapter);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ErrorInvokingApi(RestApiEvent.ErrorInvokingAPIEvent event){
        Snackbar.make(rcView,event.getErrorMsg(),Snackbar.LENGTH_INDEFINITE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataReady(RestApiEvent.DataReadyEvent event){
        adapter.setNewData(event.getAllList());
    }
}
