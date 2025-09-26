package kr.co.ch09.service;

import kr.co.ch09.dto.UserDTO;
import kr.co.ch09.entity.User;
import kr.co.ch09.repository.UserRepository;
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

        List<User> list = userRepository.findAll();
        return list.stream()
                .map(User::toDTO)
                .toList();

    }

    public UserDTO getUser(String usid){
        return null;
    }

    public UserDTO save(UserDTO  userDTO){

        // 비밀번호 암호화
        String plain = userDTO.getPass();
        String encoded = passwordEncoder.encode(plain);
        userDTO.setPass(encoded);

        User savedUser = userRepository.save(userDTO.toEntity());

        return savedUser.toDTO();
    }

    public void modify(){}
    public void delete(){}

}
