package com.fpc.test.bean;

public class HttpAnim {

    private String userName;
    private String password;
    private HttpQg qg;

    public HttpAnim() {
    }

    public HttpAnim(String userName, String password, HttpQg qg) {
        this.userName = userName;
        this.password = password;
        this.qg = qg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", qg=" + qg +
                '}';
    }

    public HttpQg getQg() {
        return qg;
    }

    public void setQg(HttpQg qg) {
        this.qg = qg;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
