package com.arkarzaw.simplehabit.viewholders.ItemDetails;

import android.view.View;

import com.arkarzaw.simplehabit.datas.VO.SessionVO;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;

import java.util.List;

import butterknife.ButterKnife;

public class SessionViewHolder extends BaseViewHolder {

    public SessionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(Object data) {

    }

    public void bindData(List<SessionVO> sessionVO){

    }
}
