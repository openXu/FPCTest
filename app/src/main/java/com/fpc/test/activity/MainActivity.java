package com.fpc.test.activity;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fpc.test.R;
import com.fzy.libs.router.RouterPath_Test;
import com.fzy.libs.router.RouterPath;
import com.fzy.mbase.activity.BaseMainActivity;

import androidx.fragment.app.Fragment;

@Route(path = RouterPath.Common.PAGE_MAINSSS)
public class MainActivity extends BaseMainActivity{

    @Override
    protected void initFragment() {
        addFragment(R.id.navigation_home, (Fragment) ARouter.getInstance().build(RouterPath_Test.PAGE_MAIN_FRAGMENT_TEST).navigation());
        addFragment(R.id.navigation_mini, (Fragment) ARouter.getInstance().build(RouterPath_Test.PAGE_MAIN_FRAGMENT_BASE).navigation());
        addFragment(R.id.navigation_fun, (Fragment) ARouter.getInstance().build(RouterPath_Test.PAGE_MAIN_FRAGMENT_BASE).navigation());
        addFragment(R.id.navigation_msg, (Fragment) ARouter.getInstance().build(RouterPath_Test.PAGE_MAIN_FRAGMENT_BASE).navigation());
        addFragment(R.id.navigation_my, (Fragment) ARouter.getInstance().build(RouterPath_Test.PAGE_MAIN_FRAGMENT_BASE).navigation());
    }

}
