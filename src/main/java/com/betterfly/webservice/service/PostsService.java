package com.betterfly.webservice.service;

import com.betterfly.webservice.domain.posts.PostsRepository;
import com.betterfly.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */


@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
