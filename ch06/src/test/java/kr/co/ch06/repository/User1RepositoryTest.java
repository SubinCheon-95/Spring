package kr.co.ch06.repository;

import kr.co.ch06.entity.Child;
import kr.co.ch06.entity.Parent;
import kr.co.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ById() {
        User1 user1 = user1Repository.findUser1ByUserid("a101");
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {
        List<User1> list = user1Repository.findUser1ByName("김유신");
        System.out.println(list);
    }

    @Test
    void findUser1ByNameNot() {

    }

    @Test
    void findUser1ByIdAndName() {
    }

    @Test
    void findUser1ByIdOrName() {
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void findUser1ByNameLike() {
    }

    @Test
    void findUser1ByNameContains() {
    }

    @Test
    void findUser1ByNameStartsWith() {
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ById() {
    }

    @Test
    void countUser1ByName() {
    }


    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ChildRepository childRepository;

    @Test
    void selectParentJoinChild(){

        Parent parent = Parent.builder()
                .pid("p101")
                .name("김유신")
                .age(34).build();

        parentRepository.save(parent);

        Child child = Child.builder()
                .cid("c102")
                .pid("p101")
                .name("김영희")
                .age(11)
                .build();

        childRepository.save(child);

        List<Object[]> objectList = user1Repository.selectParentJoinChild("p101");
        System.out.println(objectList);

        for(Object[] object : objectList){

            Parent selectedParent = (Parent) object[0];
            Child selectedChild = (Child) object[1];

            System.out.println(selectedParent);
            System.out.println(selectedChild);
        }
    }
}