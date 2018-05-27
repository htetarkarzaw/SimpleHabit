package com.arkarzaw.simplehabit.network;

import com.arkarzaw.simplehabit.datas.Response.CategoryDataResponse;
import com.arkarzaw.simplehabit.datas.Response.CurrentDataResponse;
import com.arkarzaw.simplehabit.datas.Response.TopicDataResponse;
import com.arkarzaw.simplehabit.events.RestApiEvent;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeriesDataAgentImpl implements SeriesDataAgent {

    private static SeriesDataAgentImpl objInstance;
    private SimpleHabitAPI theApi;

    public final String access_token="b002c7e1a528b7cb460933fc2875e916";
    public final int page=1;

    private SeriesDataAgentImpl() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();
        theApi=retrofit.create(SimpleHabitAPI.class);
    }

    public static SeriesDataAgentImpl getInstance(){
        if(objInstance==null){
            objInstance=new SeriesDataAgentImpl();
        }
        return objInstance;
    }



    @Override
    public void loadCurrentData() {
        Call<CurrentDataResponse> loadData=theApi.getCurrentItem(access_token,page);
        loadData.enqueue(new Callback<CurrentDataResponse>() {
            @Override
            public void onResponse(Call<CurrentDataResponse> call, Response<CurrentDataResponse> response) {
                if(response.isSuccessful()){
                    CurrentDataResponse currentDataResponse =response.body();
                    EventBus.getDefault().post(new RestApiEvent.CurrentDataLoadedEvent(currentDataResponse.getCurrentVO()));

                }else {
                    EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent("Can't connect right now. [102]"));
                }
            }

            @Override
            public void onFailure(Call<CurrentDataResponse> call, Throwable t) {
                EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage()));
            }
        });

    }

    @Override
    public void loadCategory() {
        Call<CategoryDataResponse> loadData = theApi.getCategoryItem(access_token,page);
        loadData.enqueue(new Callback<CategoryDataResponse>() {
            @Override
            public void onResponse(Call<CategoryDataResponse> call, Response<CategoryDataResponse> response) {
                if(response.isSuccessful()){
                    CategoryDataResponse categoryDataResponse = response.body();
                    EventBus.getDefault().post(new RestApiEvent.CategoriesDataLoadedEvent(categoryDataResponse.getCategoriesPrograms()));
                }else {
                    EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent("Can't connect right now. [102]"));
                }
            }

            @Override
            public void onFailure(Call<CategoryDataResponse> call, Throwable t) {
                EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage()));
            }
        });
    }

    @Override
    public void loadTopic() {
            Call<TopicDataResponse> loadData = theApi.getTopicItem(access_token,page);
            loadData.enqueue(new Callback<TopicDataResponse>() {
                @Override
                public void onResponse(Call<TopicDataResponse> call, Response<TopicDataResponse> response) {
                    if(response.isSuccessful()){
                        TopicDataResponse topicDataResponse = response.body();
                        EventBus.getDefault().post(new RestApiEvent.TopicsDataLoadedEvent(topicDataResponse.getTopics()));
                    }else {
                        EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent("Can't connect right now. [102]"));
                    }
                }

                @Override
                public void onFailure(Call<TopicDataResponse> call, Throwable t) {
                    EventBus.getDefault().post(new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage()));
                }
            });
    }
}
