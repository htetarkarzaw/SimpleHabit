package com.arkarzaw.simplehabit.network;

import com.arkarzaw.simplehabit.datas.Response.CategoryDataResponse;
import com.arkarzaw.simplehabit.datas.Response.CurrentDataResponse;
import com.arkarzaw.simplehabit.datas.Response.TopicDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<CurrentDataResponse>getCurrentItem(@Field("access_token") String access_token,
                                            @Field("page") int page);


    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<CategoryDataResponse>getCategoryItem(@Field("access_token") String access_token,
                                              @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<TopicDataResponse>getTopicItem(@Field("access_token") String access_token,
                                        @Field("page") int page);


}
