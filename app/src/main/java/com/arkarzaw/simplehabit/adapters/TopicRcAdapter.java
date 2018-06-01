package com.arkarzaw.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.datas.Models.TopicModel;
import com.arkarzaw.simplehabit.viewholders.TopicViewHolder;

import java.util.ArrayList;

public class TopicRcAdapter extends RecyclerView.Adapter<TopicViewHolder> {

    Context context;
    int layoutResourceId;
    ArrayList<TopicModel> tpModel;

    public TopicRcAdapter(Context context, int layoutResourceId, ArrayList<TopicModel> tpModel) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.tpModel = tpModel;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        TopicModel topic=tpModel.get(position);
        holder.imageView.setImageResource(topic.getImage());
        holder.title.setText( topic.getTitle());
        holder.content.setText( topic.getContent());
    }

    @Override
    public int getItemCount() {
        return tpModel.size();
    }
}
