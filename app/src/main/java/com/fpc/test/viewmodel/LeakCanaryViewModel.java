package com.fpc.test.viewmodel;

import androidx.annotation.NonNull;
import io.reactivex.disposables.Disposable;

import com.fpc.test.bean.HttpAnim;
import com.fpc.test.bean.HttpQg;
import com.fzy.libs.base.BaseViewModel;
import com.fzy.libs.http.NetworkManager;
import com.fzy.libs.http.data.FzyResponse;
import com.fzy.libs.http.rx.BaseOberver;
import com.fzy.libs.utils.FLog;
import com.google.gson.Gson;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;


public class LeakCanaryViewModel extends BaseViewModel {

    public LeakCanaryViewModel(@NonNull Application application) {
        super(application);
    }

    public Map<String, String> map = new HashMap<>();

    public void fzyGet1(){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        // "{\"code\":100, \"massage\":\"请求成功\", \"data\":[{\"userName\":\"11111\", \"password\":\"11111\"}, {\"userName\":\"222222\", \"password\":\"222222\"}, {\"userName\":\"2333333\", \"password\":\"33333\"}]}}";
        FzyResponse response = new FzyResponse(100, "请求成功", new HttpAnim("name", "psw", new HttpQg("眼睛", map)));
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<HttpAnim>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                mDisposable.add(d);
            }
            @Override
            public void onStart() { showDialog();}
            @Override
            public void onSuccess(HttpAnim data) {
                FLog.i("fzyGet1返回数据："+data);
            }
            @Override
            public void onFinish() { dismissDialog();}
        });
    }

    public void fzyGet2(){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        // "{\"code\":100, \"massage\":\"请求成功\", \"data\":[{\"userName\":\"11111\", \"password\":\"11111\"}, {\"userName\":\"222222\", \"password\":\"222222\"}, {\"userName\":\"2333333\", \"password\":\"33333\"}]}}";
        FzyResponse response = new FzyResponse(100, "请求成功", new HttpAnim("name", "psw", new HttpQg("眼睛", map)));
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<HttpAnim>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                mDisposable.add(d);
            }
            @Override
            public void onStart() { showDialog();}
            @Override
            public void onSuccess(HttpAnim data) {
                FLog.i("fzyGet2返回数据："+data);
            }
            @Override
            public void onFinish() { dismissDialog();}
        });
    }
}
