package com.fpc.test.mvvm;

import android.app.Application;

import com.fzy.libs.base.BaseViewModel;
import com.fzy.libs.http.HttpCallBack;
import com.fzy.libs.http.NetworkManager;
import com.fzy.libs.http.OneSentence;
import com.fzy.mbase.entry.User;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author: openXu
 * Time: 2019/2/26 9:48
 * class: UserViewModel
 * Description:
 */
public class UserViewModel extends BaseViewModel {

    private String userId;
    //    private User user;
    //LiveData 是一个可以感知 Activity 、Fragment生命周期的数据容器。
    // 当 LiveData 所持有的数据改变时，它会通知相应的界面代码进行更新。
    // 同时，LiveData 持有界面代码 Lifecycle 的引用，这意味着它会在界面代码（LifecycleOwner）的生命周期处于
    // started 或 resumed 时作出相应更新，而在 LifecycleOwner 被销毁时停止更新。
    private LiveData<User> user = new MutableLiveData<>();;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String userId) {
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void login() {
        Map<String, String> params = new HashMap<>();
        params.put("date", "2019-02-22");
        NetworkManager.getInstance().doGet1("dsapi/", params, new HttpCallBack<OneSentence>(){
            @Override
            public void onSeccuce(OneSentence data) {
                ((MutableLiveData<User>) user).setValue(new User("openxu Login", "123456"));
            }
            @Override
            public void onError(String msg) {

            }
        });
    }

}