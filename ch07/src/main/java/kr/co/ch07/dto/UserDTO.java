package kr.co.ch07.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String usid;
    private String pass;
    private String name;
    private int age;
    private String role;
    private String regDate;

    public User toEntity(){
        return User.builder()
                .usid(usid)
                .pass(pass)
                .name(name)
                .age(age)
                .role(role)
                .build();
    }

}
