package com.betterfly.webservice.dto;

import com.betterfly.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */


@Getter
@Setter
/*
    지금까지 @Setter 를 사용하지 않았는데,
    사용한 이유는 Contorller에서 @RequestBody로 외부에서 데이터 받은 경우
    기본생성자 + set메소드를 통해서만 값이 할당한다. 이 경우에만 @Setter 사용해줌
 */
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
