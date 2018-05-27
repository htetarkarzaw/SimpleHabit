package com.arkarzaw.simplehabit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.ViewHolders.CardViewHolder;

public class CateRcAdapter extends BaseRecyclerAdapter<CardViewHolder, ProgramVO> {

    public CateRcAdapter(Context context) {
        super(context);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.view_holder_card, parent, false);
        return new CardViewHolder(view);
    }


}
