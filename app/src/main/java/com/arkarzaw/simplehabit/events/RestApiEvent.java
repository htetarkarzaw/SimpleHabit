package com.arkarzaw.simplehabit.events;

import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.datas.VO.CategoryVO;
import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.arkarzaw.simplehabit.datas.VO.ProgramVO;
import com.arkarzaw.simplehabit.datas.VO.TopicVO;

import java.util.List;

public class RestApiEvent {

    public static class ErrorInvokingAPIEvent{
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class CurrentDataLoadedEvent {
        private CurrentVO currentVO;

        public CurrentDataLoadedEvent(CurrentVO currentVO) {
            this.currentVO = currentVO;
        }

        public CurrentVO getCurrentVO() {
            return currentVO;
        }
    }

    public static class ProgramLoadEvent{
        ProgramVO programVO;

        public ProgramLoadEvent(ProgramVO programVO) {
            this.programVO = programVO;
        }

        public ProgramVO getProgramVO() {
            return programVO;
        }
    }

    public static class CategoriesDataLoadedEvent {
        private List<CategoryVO> loadCategories;

        public CategoriesDataLoadedEvent(List<CategoryVO> loadCategories) {
            this.loadCategories = loadCategories;
        }

        public List<CategoryVO> getLoadCategories() {
            return loadCategories;
        }
    }

    public static class TopicsDataLoadedEvent {
        private List<TopicVO> loadTopics;

        public TopicsDataLoadedEvent(List<TopicVO> loadTopics) {
            this.loadTopics = loadTopics;
        }

        public List<TopicVO> getLoadTopics() {
            return loadTopics;
        }
    }

    public static class DataReadyEvent{
        private List<BaseVO> baseVOList;


        public DataReadyEvent(List<BaseVO> baseVOList) {
            this.baseVOList = baseVOList;
        }

        public List<BaseVO> getAllList(){
            return baseVOList;
        }
    }
}
