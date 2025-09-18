package kr.co.ch04.service;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Mapper mapper;

    public List<User1DTO> getUsers() {
        return mapper.selectAll();
    }

    public User1DTO getUser(String uid) {
        return mapper.select(uid);
    }

    public void save(User1DTO user) {
        mapper.insert(user);
    }

    public void update(User1DTO user) {
        mapper.update(user);
    }

    public void delete(String uid) {
        mapper.delete(uid);
    }
}