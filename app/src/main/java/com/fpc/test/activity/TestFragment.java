package com.fpc.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.BR;
import com.fpc.test.R;
import com.fpc.test.bean.MainItem;
import com.fpc.test.databinding.FragmentTestBinding;
import com.fpc.test.databinding.FragmentTestItemBinding;
import com.fpc.test.design.DesignActivity;
import com.fzy.libs.base.adapter.CommandRecyclerAdapter;
import com.fzy.libs.base.adapter.ViewHolder;
import com.fzy.libs.router.RouterPath_Test;
import com.fzy.libs.utils.FLog;
import com.fzy.libs.utils.StatusBarUtil;
import com.fzy.libs.utils.notifycation.NotifyManager;
import com.fzy.libs.utils.notifycation.NotifyMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Author: openXu
 * Time: 2019/3/7 16:13
 * class: TestFragment
 * Description:
 */

@Route(path = RouterPath_Test.PAGE_MAIN_FRAGMENT_TEST)
public class TestFragment extends Fragment {

    private FragmentTestBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        StatusBarUtil.setPaddingSmart(getContext(), binding.toolBar);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        List<MainItem> list = new ArrayList<>();
        list.add(new MainItem(1,"mvvm"));
        list.add(new MainItem(2,"内存泄露"));
        list.add(new MainItem(3,"网络请求"));
        list.add(new MainItem(4,"Notification"));
        list.add(new MainItem(5,"Design"));
        list.add(new MainItem(6,"数据库"));
        list.add(new MainItem(6,"数据库"));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CommandRecyclerAdapter adapter = new CommandRecyclerAdapter<MainItem>(getContext(), R.layout.fragment_test_item, list) {
            @Override
            public void convert(ViewHolder holder, MainItem bean, int position) {
                holder.getBinding().setVariable(BR.data, bean);
//                ((ItemActivityMainBinding)holder.getBinding()).setItem(bean);
                ((FragmentTestItemBinding)holder.getBinding()).btnItem.setOnClickListener(v->onItemClick(bean, position));
            }

            @Override
            public void onItemClick(MainItem bean,int position) {
                FLog.i("点击"+bean);
                switch (bean.getId()){
                    case 1:
                        ARouter.getInstance().build(RouterPath_Test.PAGE_MVVMTEST).navigation();
//                        startActivity(new Intent(mContext, MvvmTestActivity.class));
                        break;
                    case 2:
                        ARouter.getInstance().build(RouterPath_Test.PAGE_LEAK).navigation();
                        break;
                    case 3:
                        ARouter.getInstance().build(RouterPath_Test.PAGE_NETTEST).navigation();
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
}
