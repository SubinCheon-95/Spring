package kr.co.ch06.repository.board;

import kr.co.ch06.entity.board.File;
import kr.co.ch06.entity.board.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {

}
