package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController // 해당 컨트롤러 요청 메서드 반환값을 JSON 출력으로 처리
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody // 컨트롤러의 요청 메서드의 반환값을 View로 출력하지 않고 응답객체 Response body로 출력, JSON 출력
    @GetMapping("/user1")
    public ResponseEntity<List<User1DTO>> list(){
        List<User1DTO> dtoList = user1Service.getUserAll();

        // 다양한 요청 결과 정보를 프론트에 제공하기 위해 ResponseEntity로 데이터 전송
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    //@ResponseBody --> @RestController로 대체
    @GetMapping("/user1/{userid}")
    public ResponseEntity<User1DTO> user1(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);

        User1DTO user1DTO = user1Service.getUser(userid);

        return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(user1DTO);
    }

    //@ResponseBody
    @PostMapping("/user1")
    public ResponseEntity<User1DTO> register(@Valid @RequestBody User1DTO user1DTO){
        log.info("user1DTO={}", user1DTO);

        User1DTO savedUser1 = user1Service.save(user1DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser1);
    }

    //@ResponseBody
    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO user1DTO){ // @RequestBody : 요청 객체 body로 전송되는 JSON 데이터 수신
        log.info("user1DTO={}", user1DTO);

        User1DTO modifiedUser1 = user1Service.modify(user1DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser1);
    }

    //@ResponseBody
    @DeleteMapping("/user1/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);
        boolean isSuccess = user1Service.remove(userid);

        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(isSuccess);
    }
}
