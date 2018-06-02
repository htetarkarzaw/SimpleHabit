package com.arkarzaw.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arkarzaw.simplehabit.adapters.CateRcAdapter;
import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateViewHolder extends BaseViewHolder<CategoryVO> {

    @BindView(R.id.header)
    TextView header;

    @BindView(R.id.rcViewCate)
    RecyclerView rcViewCate;

    CateRcAdapter adapter;

    ItemClickListener clickListener;

    public CateViewHolder(View itemView,ItemClickListener clickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListener = clickListener;

        rcViewCate.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CateRcAdapter(itemView.getContext(),clickListener);
        rcViewCate.setAdapter(adapter);
        rcViewCate.setNestedScrollingEnabled(false);
        //rcView.setNestedScrollingEnabled(false);
    }

    @Override
    public void setData(CategoryVO data) {
        header.setText(data.getTitle());
        adapter.setNewData(data.getPrograms());
        adapter.setRootCategory(data);
    }

}
