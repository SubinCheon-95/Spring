package kr.co.ch06.repository;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.entity.User1;
import kr.co.ch06.entity.Parent;
import kr.co.ch06.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> { // <엔티티, 해당 엔티티의 @ID 속성 자료형>

    // 사용자 쿼리 메서드 정의(메서드 네이밍 규칙 이해)
    public User1 findUser1ByUserid(String userid);
    public List<User1> findUser1ByName(String name);
    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUseridAndName(String userid, String name);
    public List<User1> findUser1ByUseridOrName(String userid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByUserid(String userid);
    public int countUser1ByName(String name);

    // JPQL(JPA SQL) 실습
    @Query("SELECT u1 FROM User1 as u1 WHERE u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.name =?1")
    public List<User1> selectUser1WhereName(String name);

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.birth = :birth")
    public List<User1> selectUser1WhereBirth(@Param("birth") String birth);

    @Query("SELECT u1.userid, u1.name, u1.age FROM User1 as u1 WHERE u1.userid = :userid")
    public List<Object[]> selectUser1WhereId(@Param("userid") String userid);

    @Query("SELECT p, c FROM Parent as p " +
            "JOIN Child as c ON p.pid = c.pid " +
            "WHERE p.pid = :pid")
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);

}
