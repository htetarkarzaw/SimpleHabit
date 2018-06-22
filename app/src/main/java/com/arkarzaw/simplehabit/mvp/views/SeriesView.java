package com.arkarzaw.simplehabit.mvp.views;

import com.arkarzaw.simplehabit.datas.VO.BaseVO;

import java.util.List;

public interface SeriesView extends BaseView{

    void displayPrograms(List<BaseVO> baseVO);

    void onLaunchCurrentDetail();

    void onLaunchDetailProgram(String categoryId, String categoryItemId);

}
