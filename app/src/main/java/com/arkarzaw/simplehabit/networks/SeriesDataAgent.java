package com.arkarzaw.simplehabit.networks;

public interface SeriesDataAgent {

    void loadCurrentData(String access_token,int page);
    void loadCategory(String access_token,int page);
    void loadTopic(String access_token,int page);
}
