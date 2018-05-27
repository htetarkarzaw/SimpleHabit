package com.arkarzaw.simplehabit.ViewHolders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arkarzaw.simplehabit.adapters.CateRcAdapter;
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

    public CateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        header.setText("CateMode xyz");
        rcViewCate.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new CateRcAdapter(itemView.getContext());
        rcViewCate.setAdapter(adapter);
        //rcView.setNestedScrollingEnabled(false);
    }

    @Override
    public void setData(CategoryVO data) {
        header.setText(data.getTitle());
        adapter.setNewData(data.getPrograms());
    }

}
