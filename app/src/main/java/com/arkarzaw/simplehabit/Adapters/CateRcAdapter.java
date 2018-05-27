package com.arkarzaw.simplehabit.Adapters;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.arkarzaw.simplehabit.Data.Models.ItemModel;
import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.ViewHolders.CardViewHolder;

import java.util.ArrayList;

public class CateRcAdapter extends BaseRecyclerAdapter<CardViewHolder, ItemModel> {

    public CateRcAdapter(Context context) {
        super(context);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.view_holder_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
//        ItemModel items=itemModels.get(position);
//        holder.bgImage.setImageResource(items.getImage());
//        holder.header.setText( items.getHeader());
//        holder.time.setText( items.getTime());
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
