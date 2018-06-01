package com.arkarzaw.simplehabit.adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.TopicVO;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.viewholders.BaseViewHolder;
import com.arkarzaw.simplehabit.viewholders.CateViewHolder;
import com.arkarzaw.simplehabit.viewholders.CurrentViewHolder;
import com.arkarzaw.simplehabit.viewholders.TopicViewHolder;

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder,BaseVO> {

    private  final int CURRENT_VIEW = 0;
    private final int CATE_VIEW = 1;
    private final int TOPIC_VIEW = 2;


    ItemClickListener clickListener;
    public SeriesAdapter(Context context,ItemClickListener clickListener) {
        super(context);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder bHolder = null;
        if(viewType==CURRENT_VIEW){
            View v= mLayoutInflator.inflate(R.layout.view_holder_current,parent,false);
            bHolder= new CurrentViewHolder(v,clickListener);
        }else if(viewType==CATE_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_category,parent,false);
            bHolder= new CateViewHolder(v);
        }else if(viewType==TOPIC_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_topic,parent,false);
            bHolder= new TopicViewHolder(v);
        }
        return bHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(mData.get(position) instanceof CurrentVO){
            return CURRENT_VIEW;
        }else if(mData.get(position) instanceof CategoryVO){
            return CATE_VIEW;
        }else if(mData.get(position) instanceof TopicVO){
            return TOPIC_VIEW;
        }
        return 0;

    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//        return CURRENT_VIEW;
//    } else if (position == 1) {
//        return CATE_VIEW;
//    } else if (position == 2) {
//        return TOPIC_VIEW;
//    }
//    return CURRENT_VIEW;
//
//
//    }
}
