package com.arkarzaw.simplehabit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.adapters.SessionAdapter;
import com.arkarzaw.simplehabit.companents.ItemDetailView;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowItemActivity extends BaseAcitvity {


    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.itemDetailView)
    ItemDetailView itemDetailView;

    private CurrentVO currentVO;
    private ProgramVO programVO;
    String categoryId,programId,type;

    SessionAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_show_item_details);
        ButterKnife.bind(this,this);
        if(getIntent().hasExtra("CATEGORY_ID")){
            categoryId =getIntent().getStringExtra("CATEGORY_ID");
        }
        if(getIntent().hasExtra("PRO_ID")){
            programId =getIntent().getStringExtra("PRO_ID");
        }
        if(getIntent().hasExtra("TYPE")){
            type = getIntent().getStringExtra("TYPE");
        }
        if(type.equals("current")){
            CurrentVO current = SeriesModel.getInstance().getCurrentData();
            bindData(current);
        }else {
            ProgramVO programVO = SeriesModel.getInstance().getProgramVO(categoryId,programId);
            bindData(programVO);
        }
    }

    private void bindData(ProgramVO programVO) {
        itemDetailView.setupDescription(programVO.getDescription());
        itemDetailView.setupSession(programVO.getSessions());
        tvTitle.setText(programVO.getTitle());
    }

    private void bindData(CurrentVO current) {
        itemDetailView.setupDescription(current.getDescription());
        itemDetailView.setupSession(current.getSession());
        tvTitle.setText(current.getTitle());
    }

    @Override
    protected void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
//        EventBus.getDefault().unregister(this);
    }

}
