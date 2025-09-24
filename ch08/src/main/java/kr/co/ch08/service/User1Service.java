package kr.co.ch08.service;

import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.entity.User1;
import kr.co.ch08.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Repository user1Repository;

    public User1DTO save(User1DTO user1DTO) {

        // Entity 저장 후 저장된 Entity 반환
        User1 savedUser1 = user1Repository.save(user1DTO.toEntity());

        return savedUser1.toDTO();
    }
    public User1DTO getUser(String userid){

        Optional<User1> optUser1 = user1Repository.findById(userid);

        if(optUser1.isPresent()){
            User1 user1 = optUser1.get();
            return user1.toDTO();
        }
        return null;
    }
    public List<User1DTO> getUserAll(){

        List<User1> list = user1Repository.findAll();

        return list.stream()
                .map(entity -> entity.toDTO())
                .toList();
    }
    public User1DTO modify(User1DTO user1DTO){
        if(user1Repository.existsById(user1DTO.getUserid())){
            User1 modifiedUser1 = user1Repository.save(user1DTO.toEntity());
            return modifiedUser1.toDTO();
        }
        return null;
    }
    public boolean remove(String userid){

        if(user1Repository.existsById(userid)){
            user1Repository.deleteById(userid);
            return true;
        }
        return false;
    }


}
