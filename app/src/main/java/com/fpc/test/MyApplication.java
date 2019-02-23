package com.fpc.test;

import com.fzy.libs.base.BaseApplication;
import com.fzy.libs.config.BaseLibInitLogic;


public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void initLogic() {
        //初始化基础模块
        registerApplicationLogic(BaseLibInitLogic.class);
    }
}
