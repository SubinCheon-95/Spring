package kr.co.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @GetMapping(value = {"/manager/", "/manager/index"})
    public String index(){

        return "manager/index";
    }
}
