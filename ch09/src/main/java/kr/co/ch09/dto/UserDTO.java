package kr.co.ch09.dto;


import kr.co.ch09.entity.User;
import lombok.*;

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
