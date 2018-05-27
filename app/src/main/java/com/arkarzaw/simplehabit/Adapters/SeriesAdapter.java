package com.arkarzaw.simplehabit.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.Data.VO.CategoryVO;
import com.arkarzaw.simplehabit.Data.VO.CurrentVO;
import com.arkarzaw.simplehabit.Data.VO.TopicVO;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.ViewHolders.BaseViewHolder;
import com.arkarzaw.simplehabit.ViewHolders.CardViewHolder;
import com.arkarzaw.simplehabit.ViewHolders.CateViewHolder;
import com.arkarzaw.simplehabit.ViewHolders.CurrentViewHolder;
import com.arkarzaw.simplehabit.ViewHolders.TopicViewHolder;

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder,Object> {

    private  final int CURRENT_VIEW = 0;
    private final int CATE_VIEW = 1;
    private final int TOPIC_VIEW = 2;

    private Context context;

    public SeriesAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder bHolder = null;
        if(viewType==CURRENT_VIEW){
            View v= mLayoutInflator.inflate(R.layout.view_holder_current,parent,false);
            bHolder= new CurrentViewHolder(v);
        }else if(viewType==CATE_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_cate,parent,false);
            bHolder= new CateViewHolder(v);
        }else if(viewType==TOPIC_VIEW){
            View v=mLayoutInflator.inflate(R.layout.view_holder_topic,parent,false);
            bHolder= new TopicViewHolder(v);
        }
        return bHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
//        holder.setData(mData.get(position));
    }

//    @Override
//    public int getItemViewType(int position) {
//        if(mData.get(position) instanceof CurrentVO){
//            return CURRENT_VIEW;
//        }else if(mData.get(position) instanceof CategoryVO){
//            return CATE_VIEW;
//        }else if(mData.get(position) instanceof TopicVO){
//            return TOPIC_VIEW;
//        }
//        return 0;
//
//    }


    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
        return CURRENT_VIEW;
    } else if (position == 1) {
        return CATE_VIEW;
    } else if (position == 2) {
        return TOPIC_VIEW;
    }
    return CURRENT_VIEW;


    }
}
