package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User1DTO;
import lombok.*;

@Getter
//@Setter // Entity는 Setter 불변성을 위해 금지
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // Entity 객체 선언 어노테이션
@Table(name = "User1")
public class User1 {

    @Id // PK 컬럼 선언
    private String userid;

    @Column(name = "name") // 매핑 컬럼, 일반적으로 생략
    private String name;

    private String birth;
    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO(){
        return User1DTO.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }

}
