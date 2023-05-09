package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("회원가입에 성공해야 한다.")
    void registerTest() {
        Member member = Member.builder()
                .account("lion")
                .password(encoder.encode("aaa1234"))
                .name("라이옹~")
                .email("lion@naver.com")
                .build();

        boolean flag = memberMapper.save(member);

        assertTrue(flag);
    }

    @Test
    @DisplayName("peach라는 계정명으로 회원을 조회하면" +
            " 그 회원의 이름이 천도복숭아여야 한다.")
    void findMemberTest() {
        //given
        String acc = "peach";

        //when
        Member foundMember = memberMapper.findMember(acc);

        //then
        System.out.println("foundMember = " + foundMember);
        assertEquals("천도복숭아", foundMember.getName());
    }

    @Test
    @DisplayName("계정명이 peach인 경우 결과값이 1이 나와야 한다.")
    void accountDuplicateTest() {
        // given
        String acc = "peach";

        //when
        int count = memberMapper.isDuplicate("account", acc);

        //then
        assertEquals(1, count);
    }

    @Test
    @DisplayName("이메일이 aaa@bbb.com인 경우 결과값이 1이 나와야 한다.")
    void emailDuplicateTest() {
        // given
        String email = "aaa@bbb.com";

        //when
        int count = memberMapper.isDuplicate("email", email);

        //then
        assertEquals(1, count);
    }

    @Test
    @DisplayName("비밀번호가 암호화 되어야 한다.")
    void encodingTest() {

        // 인코딩 전 패스워드
        String rawPassword = "abc1234!";

        // 인코딩 후 패스워드
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("rawPassword = " + rawPassword);
        System.out.println("encodedPassword = " + encodedPassword);

    }

}