package org.dojo.ezspring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BasicController {

    @GetMapping("/")
    String greeting() {
        return "index";
    }

    @GetMapping("/date")
    @ResponseBody
    String mypage() {
        return new Date().toString();
    }

    @GetMapping("/test2")
    String test2() {
        var encoder = new BCryptPasswordEncoder();
        System.out.println("qwer1234");
        System.out.println(encoder.encode("qwer1234"));
        return "redirect:/list";
    }
}
