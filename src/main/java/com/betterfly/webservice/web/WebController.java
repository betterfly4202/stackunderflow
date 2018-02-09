package com.betterfly.webservice.web;

import com.betterfly.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){

        /*
            handlebars-spring-boot-starter 라이브러리를 의존성에 추가했기 때문에
            컨트롤러에서 문자열을 반환할때
            prefix : src/main/resources/templates
            suffix : .hbs
            자동 매칭하는 ViewResolver 역할
         */
        model.addAttribute("posts",postsService.findAllDesc());
        return "main";
    }

}
