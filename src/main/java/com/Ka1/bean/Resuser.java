package com.Ka1.bean;

import java.io.Serializable;

/**
 * ClassName Resuser
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
public class Resuser implements Serializable {
    Integer userid;
    String username;
    String pwd;
    String email;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Resuser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
