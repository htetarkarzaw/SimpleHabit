package com.arkarzaw.simplehabit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.viewholders.CardViewHolder;

public class CateRcAdapter extends BaseRecyclerAdapter<CardViewHolder, ProgramVO> {

    private CategoryVO categoryVO;
    ItemClickListener clickListener;

    public CateRcAdapter(Context context,ItemClickListener clickListener) {
        super(context);
        this.clickListener = clickListener;
    }



    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.view_holder_category_item, parent, false);
        return new CardViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setRootCategory(categoryVO);

    }


    public void setRootCategory(CategoryVO data) {
        categoryVO=data;
    }
}
