package kr.co.ch08.entity;

import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Table(name = "T_USER5")
public class User5 {

    private int no;
    private String name;
    private int age;
    private String gender; // M, F
    private LocalDateTime regDate;


}
