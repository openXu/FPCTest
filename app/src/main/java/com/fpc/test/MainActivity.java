package com.fpc.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.bean.MainItem;
import com.fpc.test.databinding.ActivityMainBinding;
import com.fpc.test.databinding.ItemActivityMainBinding;
import com.fpc.test.mvp.view.NetTestActivity;
import com.fpc.test.mvvm.MvvmActivity;
import com.fzy.libs.base.BaseActivity;
import com.fzy.libs.router.RouterActivityPath;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        List<MainItem> list = new ArrayList<>();
        list.add(new MainItem(1,"mvvm"));
        list.add(new MainItem(2,"路由"));
        list.add(new MainItem(3,"网络请求"));
        list.add(new MainItem(4,"消息"));
        list.add(new MainItem(5,"数据库"));


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new MainItemAdapter(list){
            @Override
            public void onItemClick(int position, MainItem data) {
                switch (data.getId()){
                    case 1:
                        startActivity(new Intent(mContext, MvvmActivity.class));
                        break;
                    case 2:
                        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                        ARouter.getInstance().build(RouterActivityPath.Common.PAGE_LOGIN).navigation();
                        break;
                    case 3:
                        startActivity(new Intent(mContext, NetTestActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(mContext, NetTestActivity.class));
                        break;
                }
            }
        });

    }



    abstract class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.ItemViewHolder>{
        private List<MainItem> mList;
        public MainItemAdapter(List<MainItem> mList) {
            this.mList = mList;
        }
        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemActivityMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.item_activity_main,parent, false);
            return new ItemViewHolder(binding);
        }
        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            holder.getBinding().setItem(mList.get(position));
            holder.setOnClickListener(R.id.btn_item, v->{
                onItemClick(position, holder.getBinding().getItem());
            });
        }
        @Override
        public int getItemCount() {
            return mList.size();
        }

        public abstract void onItemClick(int position, MainItem data);

        class ItemViewHolder extends RecyclerView.ViewHolder{
            private ItemActivityMainBinding itemBinding;
            public ItemViewHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                itemBinding = (ItemActivityMainBinding)binding;
            }
            public ItemActivityMainBinding getBinding() {
                return itemBinding;
            }

            public void setOnClickListener(int viewId,  View.OnClickListener listener) {
                if(viewId==-1){
                    itemBinding.getRoot().setOnClickListener(listener);
                }else{
                    View view = itemBinding.getRoot().findViewById(viewId);
                    view.setOnClickListener(listener);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
