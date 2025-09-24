package kr.co.ch07.controller;

import kr.co.ch07.dto.UserDTO;
import kr.co.ch07.repository.UserRepository;
import kr.co.ch07.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/user/info")
    public String info(){
        // 타임리프 시큐리티 속성으로 인증된 사용자 정보 출력
        return "user/info";
    }

    @PostMapping("/user/register")
    public String register(UserDTO  userDTO){
        userService.save(userDTO);
        return "redirect:/user/login";
    }

}
