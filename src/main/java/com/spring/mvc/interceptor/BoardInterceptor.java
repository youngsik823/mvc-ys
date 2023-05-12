package com.spring.mvc.interceptor;

import com.spring.mvc.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터셉터: 하위 컨트롤러에 요청이 들어가기 전, 후에
//         공통으로 검사할 일들을 정의해놓는 클래스
// 게시판 관련 인가 처리
@Configuration
@Slf4j
public class BoardInterceptor
        implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        // 로그인을 했는지 확인할 것임.
        // 로그인을 안했으면 로그인페이지로 강제로 리다이렉션 할 것임.
        if (!LoginUtil.isLogin(request.getSession())) {
            log.info("this request( {} ) denied!!", request.getRequestURI());
            response.sendRedirect("/members/sign-in");
            return false;
        }

        // 삭제요청을 한다면 자기가쓴글인지 체크

        log.info("board interceptor pass!!");
        return true;
    }
}
