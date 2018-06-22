package com.arkarzaw.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.adapters.SessionAdapter;
import com.arkarzaw.simplehabit.companents.ItemDetailView;
import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.mvp.presenters.ShowItemPresenter;
import com.arkarzaw.simplehabit.mvp.views.ShowItemView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowItemActivity extends BaseAcitvity implements ShowItemView{


    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.itemDetailView)
    ItemDetailView itemDetailView;

    private CurrentVO currentVO;
    private ProgramVO programVO;
    String categoryId,programId,type;

    SessionAdapter adapter;
    ShowItemPresenter mPresenter;

    public static void getInstanceCurrent(Context context){
        Intent intent = new Intent(context,ShowItemActivity.class);
        intent.putExtra("TYPE","current");
        context.startActivity(intent);
    }

    public static void getInstanceCategory(Context context,String categoryId,String programId){
        Intent showItem = new Intent(context,ShowItemActivity.class);
        showItem.putExtra("CATEGORY_ID", categoryId);
        showItem.putExtra("PRO_ID",programId);
        showItem.putExtra("TYPE","category");
        context.startActivity(showItem);
    }

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
        mPresenter = new ShowItemPresenter(this);
        mPresenter.onFinishUISetUp(categoryId,programId,type);

    }



    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }

    @Override
    public void displayCurrentProgramDetail(CurrentVO currentVO) {
        itemDetailView.setupDescription(currentVO.getDescription());
        itemDetailView.setupSession(currentVO.getSession());
        tvTitle.setText(currentVO.getTitle());
    }

    @Override
    public void displayCategoryProgramDetail(ProgramVO programVO) {
        itemDetailView.setupDescription(programVO.getDescription());
        itemDetailView.setupSession(programVO.getSessions());
        tvTitle.setText(programVO.getTitle());
    }

    @Override
    public void displayErrorMsg(String errMessage) {

    }
}
