package com.arkarzaw.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.datas.VO.SessionVO;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SessionViewHolder extends BaseViewHolder<SessionVO> {

    @BindView(R.id.tvNumber)
    TextView tvNumber;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDuration)
    TextView tvDuration;

    public SessionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(SessionVO data) {
        tvTitle.setText(data.getTitle());
        tvDuration.setText(data.getLengthInSec());
    }

    public void setNumber(int i) {
        tvNumber.setText(String.valueOf(i));
    }
}
