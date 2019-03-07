package com.fpc.test.bean;

/**
 * Author: openXu
 * Time: 2019/3/5 18:02
 * class: HttpQtBean
 * Description:
 */
public class HttpQtBean {

    private HttpAnim anim;
    private String banji;

    public HttpQtBean() {
    }

    public HttpQtBean(HttpAnim anim, String banji) {
        this.anim = anim;
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "HttpQtBean{" +
                "anim=" + anim +
                ", banji='" + banji + '\'' +
                '}';
    }

    public HttpAnim getAnim() {
        return anim;
    }

    public void setAnim(HttpAnim anim) {
        this.anim = anim;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
}
