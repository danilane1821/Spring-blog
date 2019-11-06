package com.codeup.blog.blog;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "Int(11) UNSIGNED",nullable = false)
    private long id;

    @Column(columnDefinition = "tinyInt(3) UNSIGNED",nullable = false, unique = true)
    private int age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "char(2) default 'XX'")
    private String reside_State;

    public Dogs(long id, int age, String name, String residentState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_State = residentState;
    }
    public Dogs() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidentState() {
        return reside_State;
    }

    public void setResidentState(String residentState) {
        this.reside_State = residentState;
    }
}


