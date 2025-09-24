package kr.co.ch07.service;

import kr.co.ch07.dto.UserDTO;
import kr.co.ch07.entity.User;
import kr.co.ch07.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getUsers(){
        return null;
    }
    public UserDTO getUser(String usid){
        return null;
    }

    public void save(UserDTO  userDTO){

        // 비밀번호 암호화
        String plain = userDTO.getPass();
        String encoded = passwordEncoder.encode(plain);
        userDTO.setPass(encoded);

        userRepository.save(userDTO.toEntity());
    }

    public void modify(){}
    public void delete(){}

}
