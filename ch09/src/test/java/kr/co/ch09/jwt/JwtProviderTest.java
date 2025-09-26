package kr.co.ch09.jwt;

import io.jsonwebtoken.Claims;
import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .usid("a101")
                .pass("1234")
                .name("홍길동")
                .role("ADMIN")
                .age(23)
                .build();

        String token = jwtProvider.createToken(user, -1);
        System.out.println(token);
    }

    @Test
    void getClaims() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyOTAxLCJleHAiOjE3NTg4NDkzMDEsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.O8nZ0s-7L8d2921hz8ZNNf_-J05yrIGykx__nfU0TS4";

        Claims claims = jwtProvider.getClaims(token);
        System.out.println(claims);
    }

    @Test
    void getAuthentication() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyOTAxLCJleHAiOjE3NTg4NDkzMDEsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.O8nZ0s-7L8d2921hz8ZNNf_-J05yrIGykx__nfU0TS4";

        Authentication authentication = jwtProvider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        System.out.println(user);
    }

    @Test
    void validateToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYyOTAxLCJleHAiOjE3NTg4NDkzMDEsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.O8nZ0s-7L8d2921hz8ZNNf_-J05yrIGykx__nfU0TS4";
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGhhazA1MDNAZ21haWwuY29tIiwiaWF0IjoxNzU4NzYzNjA1LCJleHAiOjE3NTg2NzcyMDUsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.Ch1Zc2grnEqGyFms-JM-o_YmcwoQGm1FTnEBWr0RPwM";

        try {
            jwtProvider.validateToken(expiredToken);
            System.out.println("토큰 이상 없음...");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}