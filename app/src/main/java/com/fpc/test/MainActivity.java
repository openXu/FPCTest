package com.fpc.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.design.DesignActivity;
import com.fpc.test.activity.MvvmTestActivity;
import com.fpc.test.bean.MainItem;
import com.fpc.test.databinding.ActivityMainBinding;
import com.fpc.test.databinding.ItemActivityMainBinding;
import com.fpc.test.mvp.view.NetTestActivity1;
import com.fzy.libs.adapter.CommandRecyclerAdapter;
import com.fzy.libs.adapter.ViewHolder;
import com.fzy.libs.base.BaseActivity1;
import com.fzy.libs.router.RouterActivityPath;
import com.fzy.libs.router.RouterActivityPath_Test;
import com.fzy.libs.utils.notifycation.NotifyManager;
import com.fzy.libs.utils.notifycation.NotifyMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

@Route(path = RouterActivityPath_Test.PAGE_MAIN)
public class MainActivity extends BaseActivity1 {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        List<MainItem> list = new ArrayList<>();
        list.add(new MainItem(1,"mvvm"));
        list.add(new MainItem(2,"路由"));
        list.add(new MainItem(3,"网络请求"));
        list.add(new MainItem(4,"Notification"));
        list.add(new MainItem(5,"Design"));
        list.add(new MainItem(6,"数据库"));
        binding.recyclerView.setBackgroundResource(R.mipmap.btn_login);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommandRecyclerAdapter adapter = new CommandRecyclerAdapter<MainItem>(this, R.layout.item_activity_main, list) {
            @Override
            public void convert(ViewHolder holder, MainItem bean, int position) {
                ((ItemActivityMainBinding)holder.getBinding()).setItem(bean);
            }

            @Override
            public void onItemClick(MainItem bean,int position) {
                switch (bean.getId()){
                    case 1:
                        ARouter.getInstance().build(RouterActivityPath_Test.PAGE_MVVMTEST).navigation();
                        startActivity(new Intent(mContext, MvvmTestActivity.class));
                        break;
                    case 2:
                        ARouter.getInstance().build(RouterActivityPath.Common.PAGE_LOGIN).navigation();
                        break;
                    case 3:
                        startActivity(new Intent(mContext, NetTestActivity1.class));
                        break;
                    case 4:
                        Observable.timer(2, TimeUnit.SECONDS)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long aLong) throws Exception {
                                        NotifyManager.getInstance().showNotify(NotifyManager.Notify_style_general, new NotifyMsg("通知标题", "通知内容general"));
                                        NotifyManager.getInstance().showNotify(NotifyManager.Notify_style_pucker, new NotifyMsg("通知标题", "通知内容pucker"));
                                        NotifyManager.getInstance().showNotify(NotifyManager.Notify_style_fullscreen, new NotifyMsg("悬挂通知", "通知内容fullscreen"));
                                    }
                                });
                        break;
                    case 5:
                        startActivity(new Intent(mContext,DesignActivity.class));
                        break;
                }
            }
        };
        binding.recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
