package com.fpc.test.mvvm;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * 1、通过集成BaseObservable实现动态更新，
 * 2、在getter()上使用@Bindable注解，在Setter()中通知更新就可以了。
 * 3、BR是编译时生成的类，功能和R.java相似，使用@Bindable标记过的方法会在BR中生成一个相应的字段，
 * 在setter()中调用notifyPropertyChanged(BR.name)通知系统BR.name字段数据变化了， 需要更新UI
 */
public class User extends BaseObservable {
    private String name;
    private String age;
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    @Bindable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
//        notifyPropertyChanged(BR.age);
    }
}
