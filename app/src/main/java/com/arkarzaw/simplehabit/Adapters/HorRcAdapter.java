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

import com.arkarzaw.simplehabit.Models.ItemModel;
import com.arkarzaw.simplehabit.ViewHolders.HorViewHolder;

import java.util.ArrayList;

public class HorRcAdapter extends RecyclerView.Adapter<HorViewHolder> {

    Context context;
    int layoutResourceId;
    ArrayList<ItemModel> itemModels;

    public HorRcAdapter(Context context, int layoutResourceId, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.itemModels = itemModels;
    }

    @Override
    public HorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResourceId, parent, false);
        view.getLayoutParams().width = (int) (getScreenWidth() / 2.5);
        return new HorViewHolder(view);
    }

    public int getScreenWidth() {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    @Override
    public void onBindViewHolder(HorViewHolder holder, int position) {
        ItemModel items=itemModels.get(position);
        holder.bgImage.setImageResource(items.getImage());
        holder.header.setText( items.getHeader());
        holder.time.setText( items.getTime());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
