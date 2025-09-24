package kr.co.ch08.entity;

import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "T_USER3")
public class User3 {

    private String userid;
    private String name;
    private String role;
    private LocalDateTime regDate;


}
