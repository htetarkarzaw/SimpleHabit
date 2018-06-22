package com.arkarzaw.simplehabit.fragments;

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
import android.widget.Toast;

import com.arkarzaw.simplehabit.activities.ShowItemActivity;
import com.arkarzaw.simplehabit.adapters.SeriesAdapter;
import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.mvp.presenters.SeriesPresenter;
import com.arkarzaw.simplehabit.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewSeriesFragment extends Fragment implements SeriesView{

    @BindView(R.id.rcView)
    RecyclerView rcView;
    SeriesAdapter adapter;

    SeriesPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SeriesPresenter(this);
        mPresenter.onCreate();
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
        mPresenter.onActivityCreated();
        setUp();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }



    private void setUp() {
        rcView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new SeriesAdapter(getContext(),mPresenter);
        rcView.setAdapter(adapter);

    }


    @Override
    public void displayPrograms(List<BaseVO> baseVO) {
        adapter.appendNewData(baseVO);
    }

    @Override
    public void onLaunchCurrentDetail() {
        ShowItemActivity.getInstanceCurrent(getContext());
    }

    @Override
    public void onLaunchDetailProgram(String categoryId, String categoryItemId) {
        ShowItemActivity.getInstanceCategory(getContext(),categoryId,categoryItemId);
    }

    @Override
    public void displayErrorMsg(String errMessage) {
        Toast.makeText(getContext(), errMessage, Toast.LENGTH_SHORT).show();
    }
}
