package com.betterfly.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */

@RestController
public class WebRestController {

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }
}
