package com.arkarzaw.simplehabit.fragments;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arkarzaw.simplehabit.activities.ShowItemActivity;
import com.arkarzaw.simplehabit.adapters.SeriesAdapter;
import com.arkarzaw.simplehabit.controllers.HomePresenterDelecate;
import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.mvp.presenters.SeriesPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewSeriesFragment extends Fragment{

    @BindView(R.id.rcView)
    RecyclerView rcView;
    SeriesAdapter adapter;

    HomePresenterDelecate homePresenterDelecate;
    SeriesPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = homePresenterDelecate.getSeriesPresenter();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_new, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homePresenterDelecate = (HomePresenterDelecate) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUp();
    }



    private void setUp() {
        rcView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new SeriesAdapter(getContext(),mPresenter);
        rcView.setAdapter(adapter);
        mPresenter.getMBaseVO().observe(this,new Observer<List<BaseVO>>() {
            @Override
            public void onChanged(@Nullable List<BaseVO> baseVOS) {
                adapter.appendNewData(baseVOS);
            }
        });

    }

//    public void displayDataFromActivity(List<BaseVO> baseVOS) {
////        adapter.setNewData(baseVOS);
//    }

}
