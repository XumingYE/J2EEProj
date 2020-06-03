package com.Ka1.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * ClassName Resorder
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
public class Resorder implements Serializable {
    Integer roid;
    Integer userid;
    String address;
    String tel;
    Date ordertime;
    Date deliverytime;
    String ps;
    Integer status;

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Resorder{" +
                "roid=" + roid +
                ", userid=" + userid +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", ordertime=" + ordertime +
                ", deliverytime=" + deliverytime +
                ", ps='" + ps + '\'' +
                ", status=" + status +
                '}';
    }
}
