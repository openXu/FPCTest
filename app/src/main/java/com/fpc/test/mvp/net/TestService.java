package com.fpc.test.mvp.net;

import com.fpc.test.mvp.bean.OneSentence;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestService {
    /*
     * http://open.iciba.com/dsapi/?date=2019-02-15
     * @Query 用于@GET方法的查询参数 key-value
     */
    @GET("dsapi/")
    Call<OneSentence> getSentence(@Query("date")String date) ;
}
