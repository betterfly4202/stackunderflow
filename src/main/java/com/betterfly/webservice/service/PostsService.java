package com.betterfly.webservice.service;

import com.betterfly.webservice.domain.posts.PostsRepository;
import com.betterfly.webservice.dto.PostsMainResponseDto;
import com.betterfly.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    /*
        readOnly 옵션은 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선 효과
     */
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());

        /*
            .map(PostsMainResponseDto::new)
            .map(posts -> new PostsMainResponseDto(posts)) 동일한 코드
            repository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환하여 -> List로 반환

         */
    }
}
