package com.betterfly.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */

/*
    Repository : MyBatis에서 DAO로 불리는 DB Layer 접근자
    JPA에서 사용시,
    인터페이스로 생성 후,  JpaRepository<Entity클래스, PK타입> 상속하면 기본적인 CRUD 메소드 자동 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p "+
            "FROM Posts p "+
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
