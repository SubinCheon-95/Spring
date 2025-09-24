package kr.co.ch06.service;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.entity.User1;
import kr.co.ch06.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void save(User1DTO user1DTO) {
        // DTO를 Entity로 변환
        User1 user1 = user1DTO.toEntity();

        // save() : JPA 기본 Insert 메서드
        user1Repository.save(user1);
    }

    public User1DTO getUser(String userid) {
        /*
            findById() : JPA 기본 select 메서드, 반환값은 Optional 타입
            Optional<엔티티> 타입은 null 체크 검정을 안전하게 처리하기 위한 JPA 반환 타입
        */
        Optional<User1> optUser1 = user1Repository.findById(userid);

        // 해당 사용자 Entity가 존재하면 안전하게 처리하기 위해 검사
        if(optUser1.isPresent()) {

            User1 user1 = optUser1.get();

            // Entity를 DTO로 변환해서 반환
            return user1.toDTO();
        }

        // 존재하지 않으면 null 반환
        return null;
    }

    public List<User1DTO> getUsers() {

        // findAll() : JPA 전체 조회 메서드
        List<User1> list = user1Repository.findAll();

        // DTO 리스트 변환
        /*
        List<User1DTO> dtoList = new ArrayList<>();

        for(User1 user1 : list) {
            dtoList.add(user1.toDTO());
        }
        */

        List<User1DTO> dtoList = list.stream()
                                        .map(entity -> entity.toDTO())
                                        .collect(Collectors.toList());
        return dtoList;
    }

    public void modify(User1DTO user1DTO) {

        // 수정 대상 Entity 존재 확인
        if(user1Repository.existsById(user1DTO.getUserid())){
            
            // DTO를 Entity로 변환
            User1 user1 = user1DTO.toEntity();
            
            // Entity 수정
            user1Repository.save(user1); // 기존 Entity값을 save()로 수정
        }
    }
    public void delete(String userid) {
        // deleteById() : JPA 기본 삭제 메서드
        user1Repository.deleteById(userid);
    }
}
