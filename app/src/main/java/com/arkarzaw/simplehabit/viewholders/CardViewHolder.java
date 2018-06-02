package com.arkarzaw.simplehabit.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.bgImage)
    public ImageView bgImage;

    @BindView(R.id.header)
    public TextView header;

    @BindView(R.id.time)
    public TextView time;

    private CategoryVO categoryVO;
    private ProgramVO programVO;
    ItemClickListener itemClickListener;
    public CardViewHolder(View itemView,ItemClickListener clickListener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.itemClickListener = clickListener;
    }

    @Override
    public void setData(ProgramVO data) {
        header.setText(data.getTitle());
        time.setText(data.getAvgLengths().get(0)+"mins");
        programVO = data;
    }

    public void setRootCategory(CategoryVO category){
        categoryVO = category;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        itemClickListener.onCategoryItemClick(categoryVO.getCategoryId(),programVO.getProgramId());
    }
}
