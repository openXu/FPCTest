package com.fpc.test.mvp.model;

import com.fpc.test.mvp.bean.OneSentence;
import com.fpc.test.mvp.callback.ITestCallback;
import com.fpc.test.mvp.net.TestService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class TestModel {

    private ITestCallback callback;

    public TestModel(ITestCallback callback){
        this.callback = callback;
    }


    public void  getOneSentence(String date) {
        //1. 创建 Retrofit 实例  http://open.iciba.com/dsapi/?date=2019-02-15
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://open.iciba.com/") // 设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava平台
                .build();
        //2. 创建 网络请求接口 的实例
        TestService request = retrofit.create(TestService.class);
        //3. 对 发送请求 进行封装
        Call<OneSentence> call = request.getSentence(date);

            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        Response<OneSentence> response = call.execute();
                        Thread.sleep(3000);   //模拟耗时，引起内存泄漏
                        callback.onSeccuce(response.body());
                    } catch (Exception e) {
                        e.printStackTrace();
                        callback.onFaild("获取数据失败:" + e.getMessage());
                    }
                }
            }.start();
    }
}
