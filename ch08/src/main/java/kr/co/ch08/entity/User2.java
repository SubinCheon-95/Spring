package kr.co.ch08.entity;

import jakarta.persistence.Table;

@Table(name = "T_USER2")
public class User2 {

    private String userid;
    private String name;
    private int age;
    private String address;


}
