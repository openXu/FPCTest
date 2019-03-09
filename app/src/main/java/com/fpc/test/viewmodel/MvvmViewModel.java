package com.fpc.test.viewmodel;

import android.app.Application;

import com.fpc.test.bean.Anim;
import com.fpc.test.bean.ObservableUser;
import com.fzy.libs.base.BaseViewModel;
import com.fzy.libs.net.NetworkManager;
import com.fzy.libs.net.OneSentence;
import com.fzy.libs.net.rx.BaseOberver;
import com.fzy.mbase.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Author: openXu
 * Time: 2019/2/26 9:48
 * class: MvvmViewModel
 * Description:
 */
public class MvvmViewModel extends BaseViewModel {

    //    private User user;
    //LiveData 是一个可以感知 Activity 、Fragment生命周期的数据容器。
    // 当 LiveData 所持有的数据改变时，它会通知相应的界面代码进行更新。
    // 同时，LiveData 持有界面代码 Lifecycle 的引用，这意味着它会在界面代码（LifecycleOwner）的生命周期处于
    // started 或 resumed 时作出相应更新，而在 LifecycleOwner 被销毁时停止更新。

    //简单类型LiveData直接在layout中引用viewModel.liveStr
    public LiveData<String> liveStr = new MutableLiveData<>();
    //不能直接在layout中引用 viewModel.user.userName报错
    //下面两种就只能在UI中添加observe，观察到变化后通过binding.setUser(user);
    public LiveData<User> user = new MutableLiveData<>();
    public MutableLiveData<List<User>> userList = new MutableLiveData<>();

    public MutableLiveData<Anim> anim = new MutableLiveData<>();

    //可直接在layout中引用viewModel.oUser.userName，但是bean中需要为每个字段加注解@Bindable
    public ObservableUser oUser = new ObservableUser();


    public MvvmViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void login() {
        Map<String, String> params = new HashMap<>();
        params.put("date", "2019-02-22");
        NetworkManager.getInstance().doGetByRx("dsapi/", params, "", new BaseOberver<OneSentence>(){
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(OneSentence response) {
                List<User> users = new ArrayList<>();
                users.add(new User("openxu List Login", "123456"));
                userList.setValue(users);
                ((MutableLiveData<User>) user).setValue(new User("openxu single Login", "123456"));
                ((MutableLiveData<Anim>) anim).setValue(new Anim("我是anim", 22));
                ((MutableLiveData<String>) liveStr).setValue("我是liveStr");
                oUser.setUserName("sdfsdfdsf");
            }

            @Override
            public void onFinish() {

            }
        });
    }

}