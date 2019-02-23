package com.fpc.test.mvp.callback;


import com.fpc.test.mvp.bean.OneSentence;

public interface ITestCallback {
    void onSeccuce(OneSentence data);
     void onFaild(String msg);
}
