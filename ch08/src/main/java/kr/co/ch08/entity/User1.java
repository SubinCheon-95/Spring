package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User1DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_USER1")
public class User1 {

    @Id
    private String userid;
    private String name;
    private String birth;
    private int age;

    public User1DTO toDTO(){
        return User1DTO.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}
