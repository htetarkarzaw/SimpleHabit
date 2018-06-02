package com.arkarzaw.simplehabit.datas.VO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CurrentVO implements BaseVO {

    @SerializedName("program-id")
    private String programId;
    private String title;
    @SerializedName("current-period")
    private String currentPeriod;
    private String background;
    @SerializedName("average-lengths")
    private List<Integer> avgLengths;
    private String description;
    private  List<SessionVO> sessions;


    public String getDescription() {
        return description;
    }

    public List<SessionVO> getSession() {
        return sessions;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Integer> getAvgLengths() {
        return avgLengths;
    }

    public void setAvgLengths(List<Integer> avgLengths) {
        this.avgLengths = avgLengths;
    }
}
