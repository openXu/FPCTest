package com.fpc.test.bean;

import com.fpc.test.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Author: openXu
 * Time: 2019/2/28 10:10
 * class: Cat
 * Description:
 * 1、通过集成BaseObservable实现动态更新，
 * 2、在getter()上使用@Bindable注解，在Setter()中通知更新就可以了。
 * 3、BR是编译时生成的类，功能和R.java相似，使用@Bindable标记过的方法会在BR中生成一个相应的字段，
 *    在setter()中调用notifyPropertyChanged(BR.name)通知系统BR.name字段数据变化了， 需要更新UI
 */
public class Dog {

    private ObservableField<String> name = new ObservableField<>();
    private ObservableInt age = new ObservableInt();

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
    }
}
