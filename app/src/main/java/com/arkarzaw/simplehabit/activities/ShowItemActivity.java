package com.arkarzaw.simplehabit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.adapters.ShowItemDetailAdapter;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.viewholders.CurrentViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowItemActivity extends BaseAcitvity {

    @BindView(R.id.rcItemDetails)
    RecyclerView recyclerView;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private CurrentVO currentVO;
    private ProgramVO programVO;
    String itemId,type;

    ShowItemDetailAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_show_item_details);
        ButterKnife.bind(this,this);
        if(getIntent().hasExtra("itemData")){
            itemId=getIntent().getStringExtra("itemData");
        }
        if(getIntent().hasExtra("TYPE")){
            type = getIntent().getStringExtra("TYPE");
        }
        if(type.equals("current")){
            SeriesModel.getInstance().loadCurrentData();
        }else {
            SeriesModel.getInstance().loadProgramData(itemId);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new ShowItemDetailAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onProgramLoadedEvent(RestApiEvent.ProgramLoadEvent event) {
        programVO = event.getProgramVO();
        adapter.setData(programVO);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrentProgramLoadedEvent(RestApiEvent.CurrentDataLoadedEvent event) {
        currentVO = event.getCurrentVO();
        adapter.setData(currentVO);
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
