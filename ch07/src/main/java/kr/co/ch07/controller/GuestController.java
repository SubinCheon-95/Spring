package kr.co.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

    @GetMapping(value = {"/guest/", "/guest/index"})
    public String index(){
        return "guest/index";
    }
}
