package com.fpc.test.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fpc.test.BR;
import com.fpc.test.bean.Dog;
import com.fpc.test.databinding.ActivityMvvmTestBinding;
import com.fpc.test.R;
import com.fpc.test.bean.Cat;
import com.fpc.test.viewmodel.MvvmViewModel;
import com.fzy.libs.base.BaseActivity;
import com.fzy.libs.router.RouterActivityPath_Test;
import com.fzy.mbase.bean.User;

@Route(path = RouterActivityPath_Test.PAGE_MVVMTEST)
public class MvvmTestActivity extends BaseActivity<ActivityMvvmTestBinding, MvvmViewModel> {

    @Override
    protected int getContentView(Bundle savedInstanceState) {
        return R.layout.activity_mvvm_test;
    }

    @Override
    protected int getViewModelVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {

        Cat cat = new Cat("猫猫", 1);
        binding.setCat(cat);
        Dog dog= new Dog();
        dog.getName().set("狗狗");
        dog.getAge().set(1);
        binding.setDog(dog);

        binding.setMan(true);

        User user = new User("用户名", "密码");
        binding.setUser(user);
        viewModel.user.observe(this, data->{
            binding.setUser(data);
        });
        binding.btnLogin.setOnClickListener(v->{
            cat.setAge(cat.getAge()+1);
            dog.getAge().set(dog.getAge().get()+1);

            user.setUserName("用户new");


            viewModel.login();

        });

    }

}
