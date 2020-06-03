package com.Ka1.bean;

import java.io.Serializable;

/**
 * ClassName Resorderitem
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
public class Resorderitem implements Serializable {
    Integer roiid;
    Integer roid;
    Integer fid;
    Double dealprice;
    Integer num;

    public Integer getRoiid() {
        return roiid;
    }

    public void setRoiid(Integer roiid) {
        this.roiid = roiid;
    }

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Double getDealprice() {
        return dealprice;
    }

    public void setDealprice(Double dealprice) {
        this.dealprice = dealprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Resorderitem{" +
                "roiid=" + roiid +
                ", roid=" + roid +
                ", fid=" + fid +
                ", dealprice=" + dealprice +
                ", num=" + num +
                '}';
    }
}
