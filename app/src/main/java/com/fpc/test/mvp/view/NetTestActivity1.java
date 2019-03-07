package com.fpc.test.mvp.view;

import android.os.Bundle;

import com.fpc.test.R;
import com.fpc.test.mvp.bean.OneSentence;
import com.fpc.test.mvp.presenter.TestPresenter;
import com.fzy.libs.base.BaseActivity1;

import androidx.databinding.DataBindingUtil;


public class NetTestActivity1 extends BaseActivity1 implements ITestView {


    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpnet);
        DataBindingUtil.setContentView(this,R.layout.activity_base_main);
//        btn_get.setOnClickListener(v -> {
////            new TestPresenter(this).getOneSentence();
//            presenter.getOneSentence();
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public String getDate() {
        return /*et_date.getText().toString()*/"";
    }

    @Override
    public void clearResult() {
//        tv_result.setText("");
    }

    @Override
    public void clearDate() {
//        tv_result.setText("");
    }

    @Override
    public void showData(OneSentence data) {
//        tv_result.setTextColor(Color.WHITE);
//        tv_result.setText(data.toString());
    }

    @Override
    public void showError(String msg) {
//        tv_result.setTextColor(Color.RED);
//        tv_result.setText(msg);
    }
}
