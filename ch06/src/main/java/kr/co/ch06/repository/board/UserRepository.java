package kr.co.ch06.repository.board;

import kr.co.ch06.entity.board.Article;
import kr.co.ch06.entity.board.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
