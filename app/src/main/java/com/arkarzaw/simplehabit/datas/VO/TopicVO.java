package com.arkarzaw.simplehabit.datas.VO;

import com.google.gson.annotations.SerializedName;

public class TopicVO implements BaseVO {

    @SerializedName("topic-name")
    private String topicName;
    @SerializedName("topic-desc")
    private String topicDesc;
    private String icon;
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
