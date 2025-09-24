package kr.co.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TBL_Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int cno;


    @ManyToOne(fetch = FetchType.LAZY)  // 관계설정
    @JoinColumn(name = "ano")           // FK 이름 설정
    private Article article;

    private String content;
    private String author;

    @CreationTimestamp
    private LocalDateTime wdate;
}