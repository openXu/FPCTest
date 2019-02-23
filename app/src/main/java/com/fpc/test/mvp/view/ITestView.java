package com.fpc.test.mvp.view;

import com.fpc.test.mvp.bean.OneSentence;

public interface ITestView  {

    void clearResult();
    String getDate();
    void clearDate();
    void showData(OneSentence data);

    void showError(String msg);

}
