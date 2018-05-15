package com.arkarzaw.simplehabit.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;

public class HorViewHolder extends RecyclerView.ViewHolder {

    public ImageView bgImage;
    public TextView header;
    public TextView time;

    public HorViewHolder(View itemView) {
        super(itemView);
        bgImage=itemView.findViewById(R.id.bgImage);
        header=itemView.findViewById(R.id.header);
        time=itemView.findViewById(R.id.time);
    }
}
