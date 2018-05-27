package com.arkarzaw.simplehabit.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;

public class CardViewHolder extends BaseViewHolder {

    public ImageView bgImage;
    public TextView header;
    public TextView time;

    public CardViewHolder(View itemView) {
        super(itemView);
        Log.e("EnterCard", "CardViewHolder: ");
        bgImage=itemView.findViewById(R.id.bgImage);
        header=itemView.findViewById(R.id.header);
        time=itemView.findViewById(R.id.time);
    }

    @Override
    public void setData(Object data) {

    }
}
