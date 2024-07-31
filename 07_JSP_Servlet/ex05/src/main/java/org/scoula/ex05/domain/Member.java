package org.scoula.ex05.domain;

public class Member {
    String name;
    String userid;

    public Member() {
    }

    public Member(String userid, String name) {
        this.userid = userid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
