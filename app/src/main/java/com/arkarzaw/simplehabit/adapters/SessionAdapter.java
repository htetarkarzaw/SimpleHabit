package com.arkarzaw.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.datas.VO.SessionVO;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;
import com.arkarzaw.simplehabit.viewholders.ItemDetails.DownloadViewHolder;
import com.arkarzaw.simplehabit.viewholders.SessionViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder,SessionVO> {

    public SessionAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= mLayoutInflator.inflate(R.layout.view_holder_session,parent,false);
        return new SessionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setNumber(position+1);
    }
}
