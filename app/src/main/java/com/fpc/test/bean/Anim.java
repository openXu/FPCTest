package com.fpc.test.bean;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Author: openXu
 * Time: 2019/2/28 10:10
 * class: Cat
 * Description:
 */
public class Anim {
    public Anim(String myName, int myAge) {
        this.myName = myName;
        this.myAge = myAge;
    }

    @Override
    public String toString() {
        return "HttpAnim{" +
                "myName='" + myName + '\'' +
                ", myAge=" + myAge +
                '}';
    }

    private String myName;
    private int myAge;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }
}
