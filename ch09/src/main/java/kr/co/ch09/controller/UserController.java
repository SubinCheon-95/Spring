package kr.co.ch09.controller;

import kr.co.ch09.dto.UserDTO;
import kr.co.ch09.entity.User;
import kr.co.ch09.jwt.JwtProvider;
import kr.co.ch09.security.MyUserDetails;
import kr.co.ch09.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    private final AuthenticationManager  authenticationManager;

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO userDTO) {

        // 시큐리티 인증처리
        UsernamePasswordAuthenticationToken authToken
                = new UsernamePasswordAuthenticationToken(userDTO.getUsid(), userDTO.getPass());

        Authentication authentication = authenticationManager.authenticate(authToken); // 실제 DB 조회 수행
        log.info("authentication : " + authentication);

        // 시큐리티 인증된 사용자 객체 가져오기
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        log.info("Login User: {}", userDetails);

        // 토큰 생성
        String accessToken = jwtProvider.createToken(userDetails.getUser(), 1);
        String refreshToken = jwtProvider.createToken(userDetails.getUser(), 7);
        log.info("accessToken Token: {}", accessToken);

        // 클라이언트 토큰 전송
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("accessToken", accessToken);
        resultMap.put("refreshToken", refreshToken);

        return ResponseEntity.ok(resultMap);
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO  userDTO){
        UserDTO savedUser = userService.save(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> list(){
        List<UserDTO> dtoList = userService.getUsers();

        log.info(dtoList.toString());

        return ResponseEntity.ok(dtoList);
    }

}
