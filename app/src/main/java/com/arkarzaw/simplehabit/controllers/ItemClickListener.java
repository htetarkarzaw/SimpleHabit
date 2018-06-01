package com.arkarzaw.simplehabit.controllers;

import com.arkarzaw.simplehabit.datas.VO.BaseVO;

public interface ItemClickListener {

    public void onCurrentItemClick(String datas);
    public void onCategoryItemClick();

}
