package com.arkarzaw.simplehabit.controllers;

import com.arkarzaw.simplehabit.datas.VO.BaseVO;

public interface ItemClickListener {

    public void onCurrentItemClick();
    public void onCategoryItemClick(String categoryId,String programId);

}
