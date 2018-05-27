package com.arkarzaw.simplehabit.ViewHolders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arkarzaw.simplehabit.Adapters.CateRcAdapter;
import com.arkarzaw.simplehabit.Data.Models.ItemModel;
import com.arkarzaw.simplehabit.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateViewHolder extends BaseViewHolder {

    @BindView(R.id.header)
    TextView header;

    @BindView(R.id.rcViewCate)
    RecyclerView rcViewCate;

    public CateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        header.setText("CateMode xyz");
        rcViewCate.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));




        CateRcAdapter adapter = new CateRcAdapter(itemView.getContext());
        rcViewCate.setAdapter(adapter);
        //rcView.setNestedScrollingEnabled(false);
    }

    @Override
    public void setData(Object data) {

    }
}
