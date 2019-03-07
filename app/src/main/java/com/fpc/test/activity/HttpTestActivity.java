package com.fpc.test.activity;


import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fpc.test.BR;
import com.fpc.test.databinding.ActivityHttpTestBinding;
import com.fpc.test.viewmodel.HttpTestViewModel;
import com.fzy.libs.base.BaseActivity;
import com.fpc.test.R;
import com.fzy.libs.router.RouterPath_Test;

@Route(path = RouterPath_Test.PAGE_NETTEST)
public class HttpTestActivity extends BaseActivity<ActivityHttpTestBinding, HttpTestViewModel> {

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.activity_http_test;
    }

    @Override
    protected int getViewModelVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {
        binding.btn1.setOnClickListener(v->viewModel.fzyGet1());
        binding.btn2.setOnClickListener(v->viewModel.fzyGet2());
        binding.btn3.setOnClickListener(v->viewModel.fzyGet3());
        binding.btn4.setOnClickListener(v->viewModel.fzyGet4());
    }
}
