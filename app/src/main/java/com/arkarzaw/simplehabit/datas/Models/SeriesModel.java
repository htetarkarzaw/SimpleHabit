package com.arkarzaw.simplehabit.datas.Models;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.arkarzaw.simplehabit.Constants;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.networks.SeriesDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class SeriesModel {

    public static SeriesModel objInstance;

    private SeriesModel currentModel;

    private CurrentVO currentVO;

    private ProgramVO programVO;

    private List<CategoryVO> categoryList;


    List<BaseVO> dataList = new ArrayList<>();

    private SeriesModel() {
        EventBus.getDefault().register(this);
        this.currentModel = currentModel;
    }

    public static SeriesModel getInstance() {
        if (objInstance == null) {
            objInstance = new SeriesModel();
        }
        return objInstance;
    }


    public void startLoadingSimpleHabit() {
        SeriesDataAgentImpl.getInstance().loadCurrentData(Constants.ACCESS_TOKEN, Constants.PAGE);
    }

    @Subscribe
    public void loadedCurrentData(RestApiEvent.CurrentDataLoadedEvent event) {
        dataList.add(event.getCurrentVO());
        SeriesDataAgentImpl.getInstance().loadCategory(Constants.ACCESS_TOKEN, Constants.PAGE);
    }

    @Subscribe
    public void loadedCategoryData(RestApiEvent.CategoriesDataLoadedEvent event) {
        dataList.addAll(event.getLoadCategories());
        SeriesDataAgentImpl.getInstance().loadTopic(Constants.ACCESS_TOKEN, Constants.PAGE);
    }

    @Subscribe
    public void loadedTopicData(RestApiEvent.TopicsDataLoadedEvent event) {
        dataList.addAll(event.getLoadTopics());

        RestApiEvent.DataReadyEvent dataReadyEvent = new RestApiEvent.DataReadyEvent(dataList);
        EventBus.getDefault().post(dataReadyEvent);
    }

    public @Nullable
    CurrentVO getCurrentData() {
        for (BaseVO data : dataList) {
            if (data instanceof CurrentVO)
                return (CurrentVO) data;
        }
        return null;
    }

    public @Nullable ProgramVO getProgramVO(String cateId, String programId) {
        for (BaseVO data : dataList) {
            if (data instanceof CategoryVO) {
                CategoryVO cateVO = (CategoryVO) data;
                if(TextUtils.equals(cateId,cateVO.getCategoryId())){
                    for(ProgramVO program:cateVO.getPrograms()){
                        if(TextUtils.equals(program.getProgramId(),programId)){
                            return program;
                        }
                    }
                }
            }
        }
        return null;
    }
}
