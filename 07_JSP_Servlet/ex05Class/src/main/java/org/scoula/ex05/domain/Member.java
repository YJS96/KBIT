package org.scoula.ex05.domain;

public class Member {
    private String name;
    private String userid;

    public Member() {
    }

    public Member(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }
}
