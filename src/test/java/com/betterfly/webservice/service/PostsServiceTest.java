package com.betterfly.webservice.service;

import com.betterfly.webservice.domain.posts.Posts;
import com.betterfly.webservice.domain.posts.PostsRepository;
import com.betterfly.webservice.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_Posts테이블에_저장(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                    .author("betterfly@gmail.com")
                    .content("테스트 본문")
                    .title("테스트 타이틀")
                    .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());

        //String / StringBuffer // StringBuilder 활용 TDD
    }
}
