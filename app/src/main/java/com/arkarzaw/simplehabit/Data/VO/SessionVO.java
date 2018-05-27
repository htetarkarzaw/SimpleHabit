package com.arkarzaw.simplehabit.Data.VO;

import com.google.gson.annotations.SerializedName;

public class SessionVO implements BaseVO {

    @SerializedName("session-id")
    private String sessionId;
    private String title;
    @SerializedName("length-in-seconds")
    private String lengthInSec;
    @SerializedName("file-path")
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLengthInSec() {
        return lengthInSec;
    }

    public void setLengthInSec(String lengthInSec) {
        this.lengthInSec = lengthInSec;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
