package com.fpc.test.bean;

import java.util.List;

/**
 * Author: openXu
 * Time: 2019/3/5 18:02
 * class: HttpQtBean
 * Description:
 */
public class HttpQtListBean {

    private List<HttpAnim> anims;
    private String banji;

    public HttpQtListBean() {
    }

    public HttpQtListBean(List<HttpAnim> anims, String banji) {
        this.anims = anims;
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "HttpQtListBean{" +
                "anims=" + anims +
                ", banji='" + banji + '\'' +
                '}';
    }

    public List<HttpAnim> getAnims() {
        return anims;
    }

    public void setAnims(List<HttpAnim> anims) {
        this.anims = anims;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
}
