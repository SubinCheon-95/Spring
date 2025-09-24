package kr.co.ch06.repository;

import kr.co.ch06.entity.Child;
import kr.co.ch06.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String> {
}
