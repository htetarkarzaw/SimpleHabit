package com.arkarzaw.simplehabit.mvp.presenters;

import com.arkarzaw.simplehabit.datas.Models.SeriesModel;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.mvp.views.ShowItemView;

public class ShowItemPresenter extends BasePresenter<ShowItemView> {


    @Override
    public void initPresenter(ShowItemView view) {
        super.initPresenter(view);
    }

    public void onFinishUISetUp(String categoryId, String programId, String type){
        if(type.equals("current")){
            CurrentVO current = SeriesModel.getInstance().getCurrentData();
            mView.displayCurrentProgramDetail(current);
        }else {
            ProgramVO programVO = SeriesModel.getInstance().getProgramVO(categoryId,programId);
            mView.displayCategoryProgramDetail(programVO);
        }
    }
}
