package com.arkarzaw.simplehabit.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentViewHolder extends BaseViewHolder<CurrentVO> {


    @BindView(R.id.background)
    ImageView background;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.duration)
    TextView duration;

    ItemClickListener clickListener;
    CurrentVO currentVO;

    public CurrentViewHolder(View itemView,ItemClickListener clickListener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.clickListener=clickListener;
    }

    @Override
    public void setData(CurrentVO data) {
        title.setText(data.getTitle());
        duration.setText(data.getCurrentPeriod());
        currentVO = data;
    }

    @Override
    public void onClick(View view) {
        clickListener.onCurrentItemClick();
    }
}
