package com.betterfly.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(){

        /*
            handlebars-spring-boot-starter 라이브러리를 의존성에 추가했기 때문에
            컨트롤러에서 문자열을 반환할때
            prefix : src/main/resources/templates
            suffix : .hbs
            자동 매칭하는 ViewResolver 역할
         */
        return "main";
    }
}
