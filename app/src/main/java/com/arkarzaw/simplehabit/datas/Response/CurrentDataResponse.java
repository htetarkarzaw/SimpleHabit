package com.arkarzaw.simplehabit.datas.Response;

import com.arkarzaw.simplehabit.datas.VO.CurrentVO;
import com.google.gson.annotations.SerializedName;

public class CurrentDataResponse {

    @SerializedName("code")
    int code;
    @SerializedName("message")
    String message;
    @SerializedName("apiVersion")
    String apiVersion;

    @SerializedName("currentProgram")
    CurrentVO currentVO;

    public CurrentDataResponse() {

    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public CurrentVO getCurrentVO() {
        return currentVO;
    }

    public void setCurrentVO(CurrentVO CurrentVO) {
        this.currentVO = currentVO;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
