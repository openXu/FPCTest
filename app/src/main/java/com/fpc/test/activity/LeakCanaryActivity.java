package com.fpc.test.activity;


import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fpc.test.databinding.ActivityLeakCanaryBinding;
import com.fpc.test.mvp.view.LeakTestActivity;
import com.fpc.test.viewmodel.LeakCanaryViewModel;
import com.fzy.libs.base.BaseActivity;
import com.fpc.test.R;
import com.fpc.test.BR;
import com.fzy.libs.router.RouterPath_Test;

@Route(path = RouterPath_Test.PAGE_LEAK)
public class LeakCanaryActivity extends BaseActivity<ActivityLeakCanaryBinding, LeakCanaryViewModel> {

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.activity_leak_canary;
    }

    @Override
    protected int getViewModelVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {

        binding.btn1.setOnClickListener(v->{
            startActivity(new Intent(this, LeakTestActivity.class));
        });
        binding.btn2.setOnClickListener(v->{
            viewModel.fzyGet1();
            viewModel.fzyGet2();
            finish();
        });

    }
}
