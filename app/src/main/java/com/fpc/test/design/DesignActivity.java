package com.fpc.test.design;


import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.databinding.ActivityDesignBinding;
import com.fpc.test.viewmodel.DesignViewModel;
import com.fzy.libs.base.BaseActivity;
import com.fpc.test.R;
import com.fzy.libs.router.RouterPath;
import com.fzy.libs.utils.FLog;
import com.fzy.libs.utils.toasty.FToast;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class DesignActivity extends BaseActivity<ActivityDesignBinding, DesignViewModel> {

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.activity_design;
    }

    @Override
    protected int getViewModelVariableId() {
        return 0;
    }

    @Override
    protected void initData() {
        binding.btnSnackbar.setOnClickListener(v->{
            Snackbar.make(binding.getRoot(), "标题", Snackbar.LENGTH_INDEFINITE)
                    .setAction("点击事件",view->{
                            FLog.i("点击了");
                            FToast.normal("哈哈哈3");
                    })
            .setDuration(BaseTransientBottomBar.LENGTH_LONG).show();
        });
        binding.btnTl.setOnClickListener(v-> ARouter.getInstance().build(RouterPath.MBase.PAGE_LOGIN).navigation());
    }
}
