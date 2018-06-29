package com.arkarzaw.simplehabit.datas.Models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.arkarzaw.simplehabit.Constants;
import com.arkarzaw.simplehabit.datas.Response.CategoryDataResponse;
import com.arkarzaw.simplehabit.datas.Response.CurrentDataResponse;
import com.arkarzaw.simplehabit.datas.Response.TopicDataResponse;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.datas.VO.TopicVO;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.arkarzaw.simplehabit.networks.SeriesDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class SeriesModel extends BaseModel{

    public static SeriesModel objInstance;

    private SeriesModel currentModel;

    private List<BaseVO> baseVOList =new ArrayList<>();


    private SeriesModel(Context context) {
        super(context);
        this.currentModel = currentModel;
    }

    public static void initAppModel(Context context) {
        objInstance = new SeriesModel(context);
    }
    public static SeriesModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("SimpleHabitsModel is being invoked before initializing.");
        }
        return objInstance;
    }


    public void startLoadingSimpleHabit() {
        SeriesDataAgentImpl.getInstance().loadCurrentData(Constants.ACCESS_TOKEN, Constants.PAGE);
    }

    public void startLoadingDataWithRx(final MutableLiveData<List<BaseVO>> baseVOLD,
                                       final MutableLiveData<String> errorLD){
        theApi.getCurrentItemRx(Constants.ACCESS_TOKEN, Constants.PAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(getCurrentProgramsResponse -> {
                    if (getCurrentProgramsResponse != null) {

                        CurrentVO currentVO = getCurrentProgramsResponse.getCurrentVO();
                        if (currentVO != null) {
                            baseVOList.add(currentVO);
                        }
                    }

                    return theApi.getCategoryItemRx(Constants.ACCESS_TOKEN, Constants.PAGE)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                })
                .flatMap(getCategoriesResponse -> {

                    if (getCategoriesResponse != null
                            && getCategoriesResponse.getCategoriesPrograms() != null) {

                        List<CategoryVO> categorieList = getCategoriesResponse.getCategoriesPrograms();
                        if (categorieList.size() > 0) {
                            baseVOList.addAll(categorieList);
                        }
                    }
                    return theApi.getTopicItemRx(Constants.ACCESS_TOKEN, Constants.PAGE)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                })
                .subscribe(new Observer<TopicDataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopicDataResponse getTopicResponse) {
                        if (getTopicResponse != null
                                && getTopicResponse.getTopics() != null) {

                            List<TopicVO> topicList = getTopicResponse.getTopics();
                            if (topicList.size() > 0) {
                                baseVOList.addAll(getTopicResponse.getTopics());
                            }
                        }

                        if (baseVOList.size() > 0) {
                            Log.e("BaseVo", "onNext: "+baseVOList.size() );
                            baseVOLD.setValue(baseVOList);
                        } else {
                            errorLD.setValue("No data found from network.");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

//    @Subscribe
//    public void loadedCurrentData(RestApiEvent.CurrentDataLoadedEvent event) {
//        dataList.add(event.getCurrentVO());
//        SeriesDataAgentImpl.getInstance().loadCategory(Constants.ACCESS_TOKEN, Constants.PAGE);
//    }
//
//    @Subscribe
//    public void loadedCategoryData(RestApiEvent.CategoriesDataLoadedEvent event) {
//        dataList.addAll(event.getLoadCategories());
//        SeriesDataAgentImpl.getInstance().loadTopic(Constants.ACCESS_TOKEN, Constants.PAGE);
//    }
//
//    @Subscribe
//    public void loadedTopicData(RestApiEvent.TopicsDataLoadedEvent event) {
//        dataList.addAll(event.getLoadTopics());
//
//        RestApiEvent.DataReadyEvent dataReadyEvent = new RestApiEvent.DataReadyEvent(dataList);
//        EventBus.getDefault().post(dataReadyEvent);
//    }

    public @Nullable
    CurrentVO getCurrentData() {
        for (BaseVO data : baseVOList) {
            if (data instanceof CurrentVO)
                return (CurrentVO) data;
        }
        return null;
    }

    public @Nullable ProgramVO getProgramVO(String cateId, String programId) {
        for (BaseVO data : baseVOList) {
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
