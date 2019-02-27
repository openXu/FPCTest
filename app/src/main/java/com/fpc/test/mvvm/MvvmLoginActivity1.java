package com.fpc.test.mvvm;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.BR;
import com.fpc.test.R;
import com.fpc.test.databinding.ActivityMvvmLoginBinding;
import com.fzy.libs.base.BaseActivity;
import com.fzy.libs.base.BaseActivity1;
import com.fzy.libs.router.RouterActivityPath;
import com.fzy.libs.router.RouterActivityPath_General;
import com.fzy.libs.utils.FzyLog;
import com.fzy.mbase.entry.User;


import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProviders;

@Route(path = RouterActivityPath_General.PAGE_MVVM)
public class MvvmLoginActivity1 extends BaseActivity<ActivityMvvmLoginBinding, UserViewModel> {

    /*系统提供所有基本数据类型对应的Observable类，比如ObservableInt、ObservableBoolean等*/
    public ObservableBoolean man = new ObservableBoolean();
    //基本数据类型和引用数据类型通用的ObservableField
    public ObservableField<String> name = new ObservableField<>();

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.activity_mvvm_login;
    }

    @Override
    protected int getViewModelVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {
        User user1 = new User("待登陆", "28");
        //只有通过binding设置ViewModel中的数据，UI才会更新
        binding.setUser(user1);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.init("");
        //每次更新User数据时，都会调用 onChanged() 回调并刷新界面
        //除非 Fragment 处于活跃状态（即，已接收 onStart() 但尚未接收 onStop()），
        // 否则它不会调用 onChanged() 回调。当调用 Fragment 的 onDestroy() 方法时，LiveData 还会自动移除观察者。
        viewModel.getUser().observe(this, user -> {
            // Update UI.
            Log.i(TAG, "观察到数据变化,更新界面");
            binding.setUser(user);
        });

        //事件处理
        binding.btnLogin.setOnClickListener(v->{
            ARouter.getInstance().build(RouterActivityPath.Common.PAGE_LOGIN).navigation();
            viewModel.login();
//            finish();
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        FzyLog.v("Activity--onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FzyLog.v("Activity--onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        FzyLog.v("Activity--onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        FzyLog.v("Activity--onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        FzyLog.v("Activity--onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FzyLog.v("Activity--onDestroy");
    }
}
