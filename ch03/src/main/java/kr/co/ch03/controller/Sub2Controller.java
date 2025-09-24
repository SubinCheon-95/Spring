package kr.co.ch03.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.ch03.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public String register(){
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDTO userDTO){ // 전송 파라미터 수신처리는 DTO 매개변수 선언
        System.out.println(userDTO.toString());

        // redirect 시작 문자열로 처리
        return "redirect:/index";
    }
}
