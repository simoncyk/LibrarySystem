package com.web.prjo;

/**
 * Created by simonk on 2018/03/27.
 */
public class manger {

    private String  name;
    private String PWD;
    private  int id ;
    private  int sysset ;
    private  int readerset ;
    private  int bookset ;
    private  int borrowback ;
    private  int sysquery ;
    private  String limits;

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public int getBorrowback() {

        return borrowback;
    }

    public void setBorrowback(int borrowback) {
        this.borrowback = borrowback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSysset() {
        return sysset;
    }

    public void setSysset(int sysset) {
        this.sysset = sysset;
    }

    public int getReaderset() {
        return readerset;
    }

    public void setReaderset(int readerset) {
        this.readerset = readerset;
    }

    public int getBookset() {
        return bookset;
    }

    public void setBookset(int bookset) {
        this.bookset = bookset;
    }

    public int getSysquery() {
        return sysquery;
    }

    public void setSysquery(int sysquery) {
        this.sysquery = sysquery;
    }






}
