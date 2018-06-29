package com.arkarzaw.simplehabit.networks;

import com.arkarzaw.simplehabit.datas.Response.CategoryDataResponse;
import com.arkarzaw.simplehabit.datas.Response.CurrentDataResponse;
import com.arkarzaw.simplehabit.datas.Response.TopicDataResponse;

import io.reactivex.Observable;
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
    @POST("getCurrentProgram.php")
    Observable<CurrentDataResponse> getCurrentItemRx(@Field("access_token") String access_token,
                                                     @Field("page") int page);


    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<CategoryDataResponse>getCategoryItem(@Field("access_token") String access_token,
                                              @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Observable<CategoryDataResponse>getCategoryItemRx(@Field("access_token") String access_token,
                                              @Field("page") int page);


    @FormUrlEncoded
    @POST("getTopics.php")
    Call<TopicDataResponse>getTopicItem(@Field("access_token") String access_token,
                                        @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Observable<TopicDataResponse>getTopicItemRx(@Field("access_token") String access_token,
                                        @Field("page") int page);


}
