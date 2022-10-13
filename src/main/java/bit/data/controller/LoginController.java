package bit.data.controller;

import bit.data.dto.UserDto;
import bit.data.service.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user") // 공통매핑
public class LoginController {
    @Autowired
    UserServiceInter userService;

    // 커윗소개
    @GetMapping("/intro")
    public String intro(HttpSession session){
        session.removeAttribute("intro");
        return "/bit/layout/introduction";
    }

    //로그인 폼 매핑
    @GetMapping("/login_main")
    public String loginForm(HttpSession session) {
        session.removeAttribute("login_ok");
        return "/bit/login/login_form";
    }

    // 로그인 하기
    @PostMapping("/login") // loginprocess
    public String login(String email_id, String ur_pw, HttpSession session) {
        Map<String, String> map = new HashMap<String, String>();
        int result = userService.getIdPassCheck(email_id, ur_pw);
        // 아이디와 패스워드 모두 일치하는 경우 (result == 1)
        if (result == 1) {
            UserDto dto = userService.selectEmailId(email_id);
            // 세션주기 // 로그인 유지 4시간
            session.setMaxInactiveInterval(60 * 60 * 4);
            session.setAttribute("login_ok", "yes");
            session.setAttribute("login_id", dto.getUr_id());
            session.setAttribute("login_nick", dto.getUr_nk());
            session.setAttribute("login_img", dto.getUr_img());
            // 로그인시 메인 화면으로 보내기
            //return "redirect:../";
            return "/bit/layout/main";
        } else {
            // 아이디 또는 패스워드가 일치하지 않는 경우 (no)
            session.setAttribute("login_ok","no");
            // 다시 로그인 폼으로 이동
            // return "redirect:../login_main";
            return "/bit/login/login_form";
        }
    }

    // 로그아웃 하기
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //로그아웃시 제거되어야할 세션
        session.removeAttribute("login_ok");
        session.removeAttribute("login_id");
        session.removeAttribute("login_nick");
        session.removeAttribute("login_img");
        // 로그아웃시 메인 화면으로 보내기
        //return "redirect:../";
        return "/bit/layout/main";
    }

    // 로그아웃 - User Cotroller
//    @GetMapping("/logout")
//    public String logout() { return "/bit/logout";}

    // 아이디 찾기
    @GetMapping("/find_id")
    public String findid() {
        return "/bit/login/find_id";
    }

    // 비밀번호 찾기
    @GetMapping("/find_pw")
    public String findpw() {
        return "/bit/login/find_pw";
    }

    //[임시] 세션 저장
    @GetMapping("/call_session")
    @ResponseBody
    public void callSession(HttpSession session) {
        session.setMaxInactiveInterval(60 * 60 * 12);

        UserDto dto = userService.selectDataById(2);
//        System.out.println(dto.getUr_id());
//        System.out.println(dto.getEmail_id());
//        System.out.println(dto.getUr_nk());

        session.setAttribute("login_ok", "yes");
        session.setAttribute("login_id", dto.getUr_id());
        session.setAttribute("login_nick", dto.getUr_nk());
        session.setAttribute("login_img", dto.getUr_img());
    }


    //[임시] 세션 제거
    @GetMapping("/del_session")
    @ResponseBody
    public void delSession(HttpSession session) {

        session.removeAttribute("login_ok");
        session.removeAttribute("login_id");
        session.removeAttribute("login_img");
        session.removeAttribute("login_nick");
        session.removeAttribute("cfCmtCnt");
        session.removeAttribute("cfLkCnt'");
    }
}

