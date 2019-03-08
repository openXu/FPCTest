package com.fpc.test.mvp.presenter;

import com.fpc.test.mvp.bean.OneSentence;
import com.fpc.test.mvp.callback.ITestCallback;
import com.fpc.test.mvp.model.TestModel;
import com.fpc.test.mvp.view.ITestView;
import com.fzy.libs.utils.FLog;


public class TestPresenter {

    private ITestView view;
    private TestModel model;

    public TestPresenter(ITestView view){
        this.view = view;
        model = new TestModel(new ITestCallback() {
            @Override
            public void onSeccuce(OneSentence data) {
                FLog.e("数据请求回来了，但是activity“销毁了”");
                view.showData(data);
            }

            @Override
            public void onFaild(String msg) {
                view.showError(msg);
            }
        });
    }
    public void getOneSentence() {
        view.clearResult();
        model.getOneSentence(view.getDate());
    }


}

