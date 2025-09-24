package kr.co.ch06.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_CUSTOMER")
public class Customer {

    @Id
    private String custId;
    private String name;
    private int age;
    private String addr;

    @CreationTimestamp
    private LocalDateTime regDate;

    // 추가필드, 테이블 컬럼 속성 제외
    @Transient
    private long orderCount;

}
