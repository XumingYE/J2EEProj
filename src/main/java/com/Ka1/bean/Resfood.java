package com.Ka1.bean;

import java.io.Serializable;

/**
 * ClassName Resfood
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
public class Resfood implements Serializable {
    private Integer fid;
    private String fname;
    private Double normprice;
    private Double realprice;
    private String detail;
    private String fphoto;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Double getNormprice() {
        return normprice;
    }

    public void setNormprice(Double normprice) {
        this.normprice = normprice;
    }

    public Double getRealprice() {
        return realprice;
    }

    public void setRealprice(Double realprice) {
        this.realprice = realprice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFphoto() {
        return fphoto;
    }

    public void setFphoto(String fphoto) {
        this.fphoto = fphoto;
    }

    @Override
    public String toString() {
        return "Resfood{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", normprice=" + normprice +
                ", realprice=" + realprice +
                ", detail='" + detail + '\'' +
                ", fphoto='" + fphoto + '\'' +
                '}';
    }
}
