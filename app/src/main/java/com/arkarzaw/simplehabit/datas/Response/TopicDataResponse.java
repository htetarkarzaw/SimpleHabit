package com.arkarzaw.simplehabit.datas.Response;

import com.arkarzaw.simplehabit.datas.VO.TopicVO;

import java.util.List;

public class TopicDataResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicVO> getTopics() {
        return topics;
    }

    private List<TopicVO> topics;
}
