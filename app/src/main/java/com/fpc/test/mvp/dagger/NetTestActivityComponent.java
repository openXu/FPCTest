package com.fpc.test.mvp.dagger;

import com.fpc.test.mvp.view.NetTestActivity1;


/**
 * 中间类@Component用于完成依赖注入
 */
public interface NetTestActivityComponent {
    void inject(NetTestActivity1 activity);
}
