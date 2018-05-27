package com.arkarzaw.simplehabit.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;

public class TopicViewHolder extends BaseViewHolder {

    public ImageView imageView;
    public TextView title;
    public TextView content;
    public TopicViewHolder(View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageView);
        title=itemView.findViewById(R.id.title);
        content=itemView.findViewById(R.id.content);
    }

    @Override
    public void setData(Object data) {

    }
}
