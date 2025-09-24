package kr.co.ch06.repository.board;

import kr.co.ch06.entity.board.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
