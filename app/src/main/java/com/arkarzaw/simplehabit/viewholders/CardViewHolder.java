package com.arkarzaw.simplehabit.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.bgImage)
    public ImageView bgImage;

    @BindView(R.id.header)
    public TextView header;

    @BindView(R.id.time)
    public TextView time;

    public CardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(ProgramVO data) {
        header.setText(data.getTitle());
        time.setText(data.getAvgLengths().get(0)+"mins");
    }
}
