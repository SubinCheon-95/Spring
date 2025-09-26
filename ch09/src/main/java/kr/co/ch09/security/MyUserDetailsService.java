package kr.co.ch09.security;

import kr.co.ch09.entity.User;
import kr.co.ch09.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername username: {}", username);

        // 사용자가 입력한 아이디로 사용자 조회, 비밀번호에 대한 검증은 이전 컴포넌트인 AuthenticationProvider에서 수행
        Optional<User> optUser = userRepository.findById(username);

        if(optUser.isPresent()) {

            User user = optUser.get();
            log.info("loadUserByUsername User: {}", user);

            // 인증 객체 생성1
            MyUserDetails myUserDetails = MyUserDetails.builder()
                                            .user(user)
                                            .build();

            // 반환되는 인증 객체가 Security Context Holder에 Authentication으로 저장
            return myUserDetails;
        }
        return null;
    }
}
