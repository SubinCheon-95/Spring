package kr.co.ch08.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import kr.co.ch08.entity.User1;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {

    @NotBlank // null, "", " " 모두 허용 안함
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자, 숫자 조합 최소 4 ~ 10자 입력")
    private String userid;

    @NotEmpty // null, "" 허용 안함
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "이름은 한글 2~10자 입력")
    private String name;

    @NotNull // null 허용안함
    private String birth;

    @Min(1)
    @Max(100)
    private int age;

    @Email
    private String email;

    public User1 toEntity(){
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }



}
