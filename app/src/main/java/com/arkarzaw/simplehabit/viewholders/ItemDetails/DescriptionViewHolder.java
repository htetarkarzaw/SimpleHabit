package com.arkarzaw.simplehabit.viewholders.ItemDetails;

import android.view.View;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionViewHolder extends BaseViewHolder {

    @BindView(R.id.tvDescription)
    TextView tvDescription;
    private CurrentVO currentVO;
    private ProgramVO programVO;
    public DescriptionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(Object data) {

    }

    public void bindData(String description){
        tvDescription.setText(description);
    }

}
