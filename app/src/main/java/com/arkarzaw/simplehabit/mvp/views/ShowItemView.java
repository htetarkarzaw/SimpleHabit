package com.arkarzaw.simplehabit.mvp.views;

import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;

public interface ShowItemView extends BaseView {

    void displayCurrentProgramDetail(CurrentVO currentVO);

    void displayCategoryProgramDetail(ProgramVO programVO);
}
