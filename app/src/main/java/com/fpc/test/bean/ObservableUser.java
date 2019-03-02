package com.fpc.test.bean;

import com.fpc.test.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ObservableUser extends BaseObservable {

    private String userName;
    private String password;

    public ObservableUser() {
    }

    public ObservableUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @Bindable
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
