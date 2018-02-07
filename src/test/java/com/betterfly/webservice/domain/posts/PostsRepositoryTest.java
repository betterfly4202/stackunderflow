package com.betterfly.webservice.domain.posts;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        /**
         * 이후 테스트 코드에 영향을 끼치지 않기 위해
         * 테스트 메소드가 끝날때 마다 repository를 전체 비우는 코드
         */
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        /** 테스트 기반 구축 */
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문내용")
                .author("betterFLY")
                .build());

        //when
        /** 테스트 하고자 하는 행위 */
        List<Posts> postsList = postsRepository.findAll();

        //then
        /** 테스트 결과 검증 */
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("제목1"));
        assertThat(posts.getContent(), is("내용1"));
        assertThat(posts.getAuthor(), is("betterFLY"));

    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글2")
                .content("테스트 본문")
                .author("betterfly님")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));

    }
}
