package com.arkarzaw.simplehabit.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    public CurrentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(CurrentVO data) {
        title.setText(data.getTitle());
        duration.setText(data.getCurrentPeriod());
    }


}
