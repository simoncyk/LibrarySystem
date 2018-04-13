package com.web.prjo;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2018/03/31
 * \* Time: 9:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class booktype {
    private int id;
    private String typename;
    private  String days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}