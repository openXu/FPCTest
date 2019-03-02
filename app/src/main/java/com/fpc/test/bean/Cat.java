package com.fpc.test.bean;

import com.fpc.test.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Author: openXu
 * Time: 2019/2/28 10:10
 * class: Cat
 * Description:
 */
public class Cat extends BaseObservable {

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
