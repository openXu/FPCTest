package com.fpc.test.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fpc.test.R;
import com.fpc.test.databinding.FragmentLayoutBinding;
import com.fzy.libs.router.RouterPath_Test;
import com.fzy.libs.utils.StatusBarUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * Author: openXu
 * Time: 2019/3/7 16:13
 * class: TestFragment
 * Description:
 */

@Route(path = RouterPath_Test.PAGE_MAIN_FRAGMENT_BASE)
public class FragmentBase extends Fragment {

    private FragmentLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);

        StatusBarUtil.setPaddingSmart(getContext(), binding.toolBar);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        binding.setName("哈哈");
    }
}
