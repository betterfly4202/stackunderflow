package com.betterfly.webservice.web;

import com.betterfly.webservice.dto.PostsSaveRequestDto;
import com.betterfly.webservice.domain.posts.PostsRepository;
import com.betterfly.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */

@RestController
/*
    @RestController = @Controller + @ResponseBody >> 모든 메소드에 적용
 */
@AllArgsConstructor
/*
    PostsRepository를 주입받는데 @Autowired가 없다.
    AllArgsConstructor 덕분인데, 모든 필드를 입자값으로하는 생성자를 자동 생성해준다.
    >> 이는 차후 의존성 관계가 변경되거나 생성자 코드를 계속해서 수정하는 번거로움을 해결해준다.
 */
public class WebRestController {

    private PostsRepository postsRepository;

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(
            @RequestBody PostsSaveRequestDto dto){
//        postsRepository.save(dto.toEntity());

        return postsService.save(dto);
    }

}
