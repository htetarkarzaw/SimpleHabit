package com.arkarzaw.simplehabit.datas.Models;

import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.network.SeriesDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class SeriesModel {

    public static SeriesModel objInstance;

    private SeriesModel currentModel;

    List<BaseVO> dataList = new ArrayList<>();

    private SeriesModel() {
        EventBus.getDefault().register(this);
        this.currentModel = currentModel;
    }

    public static SeriesModel getInstance(){
        if(objInstance == null) {
            objInstance = new SeriesModel();
        }
        return objInstance;
    }

    public void startLoadingSimpleHabit(){
        SeriesDataAgentImpl.getInstance().loadCurrentData();
    }

    @Subscribe
    public void loadedCurrentData(RestApiEvent.CurrentDataLoadedEvent event){
        dataList.add(event.getCurrentVO());
        SeriesDataAgentImpl.getInstance().loadCategory();
    }

    @Subscribe
    public void loadedCategoryData(RestApiEvent.CategoriesDataLoadedEvent event){
        dataList.addAll(event.getLoadCategories());
        SeriesDataAgentImpl.getInstance().loadTopic();
    }

    @Subscribe
    public void loadedTopicData(RestApiEvent.TopicsDataLoadedEvent event){
        dataList.addAll(event.getLoadTopics());

        RestApiEvent.DataReadyEvent dataReadyEvent = new RestApiEvent.DataReadyEvent(dataList);
        EventBus.getDefault().post(dataReadyEvent);
    }

}
