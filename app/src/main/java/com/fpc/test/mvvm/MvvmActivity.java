package com.fpc.test.mvvm;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fpc.test.R;
import com.fpc.test.databinding.ActivityMvvmBinding;
import com.fzy.libs.base.BaseActivity;
import com.fzy.libs.router.RouterActivityPath_General;


import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
@Route(path = RouterActivityPath_General.PAGE_MVVM)
public class MvvmActivity extends BaseActivity {

    /*系统提供所有基本数据类型对应的Observable类，比如ObservableInt、ObservableBoolean等*/
    public ObservableBoolean man = new ObservableBoolean();
    //基本数据类型和引用数据类型通用的ObservableField
    public ObservableField<String> name = new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        /**
         *  ActivityMvvmBinding是系统根据activity_mvvm.xml生成的一个ViewModel类（ Binding辅助类）
         *  Binding中包含variable节点变量的getter & setter方法，以及布局文件中所有的绑定关系，自动根据绑定关系给布局文件赋值
         */
//        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        //改变Binding命名和生成位置
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        User user = new User("openXu", "28");
        //只有通过binding设置ViewModel中的数据，UI才会更新
        binding.setUser(user);


        //事件处理
        binding.btnLogin.setOnClickListener(v->{
            user.setName("openXuNew");});
    }
}
