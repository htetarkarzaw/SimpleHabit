package com.arkarzaw.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.datas.VO.SessionVO;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;
import com.arkarzaw.simplehabit.viewholders.CurrentViewHolder;
import com.arkarzaw.simplehabit.viewholders.ItemDetails.DescriptionViewHolder;
import com.arkarzaw.simplehabit.viewholders.ItemDetails.DownloadViewHolder;
import com.arkarzaw.simplehabit.viewholders.ItemDetails.SessionViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ShowItemDetailAdapter extends BaseRecyclerAdapter {

    private  final int DOWNLOAD_VIEW = 0;
    private final int DESCRIPTION_VIEW = 1;
    private final int SESSION_VIEW = 2;
    public ShowItemDetailAdapter(Context context) {
        super(context);
    }

    private BaseVO baseVO = null;
    private CurrentVO currentVO = null;
    private ProgramVO programVO = null;
    private List<SessionVO> sessionVO = new ArrayList<>();
    private String Description;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder bHolder = null;
        if(viewType==DOWNLOAD_VIEW){
            View v= mLayoutInflator.inflate(R.layout.view_holder_download,parent,false);
            bHolder= new DownloadViewHolder(v);
        }else if(viewType==DESCRIPTION_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_description,parent,false);
            bHolder= new DescriptionViewHolder(v);
        }else if(viewType==SESSION_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_session,parent,false);
            bHolder= new SessionViewHolder(v);
        }
        return bHolder;
    }

    public void setData(BaseVO baseVO){
        this.baseVO = baseVO;
        if(baseVO instanceof CurrentVO){
            currentVO = (CurrentVO) baseVO;
            Description = currentVO.getDescription();
            sessionVO = currentVO.getSessionVOList();

        }else {
            programVO = (ProgramVO) baseVO;
            Description = programVO.getDescription();
            sessionVO = programVO.getSessions();
        }
        Log.e("Check", "setData: "+Description );
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(position==1){
            ((DescriptionViewHolder) holder).bindData(Description);
        }else if(position==2){
            ((SessionViewHolder) holder).bindData(sessionVO);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return DOWNLOAD_VIEW;
        } else if (position == 1) {
            return DESCRIPTION_VIEW;
        } else if (position == 2) {
            return SESSION_VIEW;
        }
        return DOWNLOAD_VIEW;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
