package kr.co.ch09.controller;

import kr.co.ch09.entity.User;
import kr.co.ch09.security.MyUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Authentication authentication, Model model) {
        log.info("index1 - {}", authentication);

        // 로그인 했으면
        if(authentication != null) {

            // 사용자 인증 객체에서 User 엔티티 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            log.info("index2 - {}", user);

            model.addAttribute(user);
        }

        return "index";
    }

}
