package com.fpc.test.bean;

/**
 * Author: openXu on
 * Time: 2019/2/23 16:22
 * class: MainItem
 * Description:
 */
public class MainItem {
    public MainItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
