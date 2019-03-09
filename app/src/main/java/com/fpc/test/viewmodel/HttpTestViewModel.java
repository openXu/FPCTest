package com.fpc.test.viewmodel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.fpc.test.bean.HttpAnim;
import com.fpc.test.bean.HttpQg;
import com.fpc.test.bean.HttpQtBean;
import com.fpc.test.bean.HttpQtListBean;
import com.fzy.libs.base.BaseViewModel;
import com.fzy.libs.net.NetworkManager;
import com.fzy.libs.net.data.FzyResponse;
import com.fzy.libs.net.rx.BaseOberver;
import com.fzy.libs.utils.FLog;
import com.google.gson.Gson;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HttpTestViewModel extends BaseViewModel {


    public ObservableField<String> result = new ObservableField<>();

    public HttpTestViewModel(@NonNull Application application) {
        super(application);

        map.put("mapKey1", "mapv1");
        map.put("mapKey2", "mapv2");
    }

    public Map<String, String> map = new HashMap<>();

    public void fzyGet1(){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        // "{\"code\":100, \"massage\":\"请求成功\", \"data\":[{\"userName\":\"11111\", \"password\":\"11111\"}, {\"userName\":\"222222\", \"password\":\"222222\"}, {\"userName\":\"2333333\", \"password\":\"33333\"}]}}";
        FzyResponse response = new FzyResponse(100, "请求成功", new HttpAnim("name", "psw", new HttpQg("眼睛", map)));
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<HttpAnim>() {
            @Override
            public void onStart() { showDialog();}
            @Override
            public void onSuccess(HttpAnim data) {
                FLog.i("fzyGet返回数据："+data);
                result.set(new Gson().toJson(data));
//                user.setValue(data);
            }
            @Override
            public void onFinish() { dismissDialog();}
        });
    }
    public void fzyGet2(){
        FzyResponse response = new FzyResponse(100, "请求成功", new HttpQtBean(new HttpAnim("name1", "psw1", new HttpQg("屁股" ,map)), "班级1"));
        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<HttpQtBean>() {
            @Override
            public void onStart() { showDialog(); }
            @Override
            public void onSuccess(HttpQtBean data) {
                FLog.i("fzyGet1返回数据："+data);
                result.set(new Gson().toJson(data));
            }
            @Override
            public void onFinish() { dismissDialog();  }
        });
    }
    public void fzyGet3(){
        List<HttpAnim> anims = new ArrayList<>();
        anims.add(new HttpAnim("name2", "psw2", new HttpQg("鼻子", map)));
        anims.add(new HttpAnim("name  2", "psw   2", new HttpQg("嘴巴" ,map)));
        FzyResponse response = new FzyResponse(100, "请求成功", new HttpQtListBean(anims, "班级2"));

        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<HttpQtListBean>() {
            @Override
            public void onStart() {  showDialog();  }
            @Override
            public void onSuccess(HttpQtListBean data) {
                FLog.i("fzyGet2返回数据："+data);
                result.set(new Gson().toJson(data));
            }
            @Override
            public void onFinish() {dismissDialog();}
        });
    }
    public void fzyGet4(){
        List<HttpAnim> anims = new ArrayList<>();
        anims.add(new HttpAnim("name2", "psw2", new HttpQg("鼻子" ,map)));
        anims.add(new HttpAnim("name  2", "psw   2", new HttpQg("嘴巴", map)));
        FzyResponse response = new FzyResponse(100, "请求成功", anims);

        Map<String, String> params = new HashMap<>();
        params.put("companyId", "e3c6f838-13df-11e9-bf3a-fa163e4635ff");
        NetworkManager.getInstance().doGetByRx("demo", params, new Gson().toJson(response), new BaseOberver<List<HttpAnim>>() {
            @Override
            public void onStart() {  showDialog();  }
            @Override
            public void onSuccess(List<HttpAnim> data) {
                FLog.i("fzyGet3返回数据："+data);
                result.set(new Gson().toJson(data));
            }
            @Override
            public void onFinish() {dismissDialog();}
        });
    }
}
