package com.arkarzaw.simplehabit.companents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.adapters.SessionAdapter;
import com.arkarzaw.simplehabit.datas.VO.SessionVO;
import com.arkarzaw.simplehabit.myLibs.RecyclerViewStatic;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailView extends NestedScrollView {

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.rcSession)
    RecyclerView rcSession;
    public ItemDetailView(Context context) {
        super(context);
    }

    public ItemDetailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemDetailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setupDescription(String description){
        tvDescription.setText(description);
    }

    public void setupSession(List<SessionVO> sessionVOList){
        rcSession.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        SessionAdapter adapter = new SessionAdapter(getContext());
        rcSession.setAdapter(adapter);
        adapter.setNewData(sessionVOList);
    }


}
