package com.betterfly.webservice.domain.posts;

import com.betterfly.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by betterFLY on 2018. 2. 6.
 * Github : http://github.com/betterfly88
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
    기본 생성자 자동추가 기능
        access = AccessLevel.PROTECTED : 기본 생성자의 접근 권한을 protected 로 제한
        > 생성자로 protected Posts()와 같은 효과
        Entity클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity클래스를 생성하는 것은 허용하기 위해 추가
 */
@Getter
/*
    클래스내 모든 필드의 Getter 메소드 자동 생성
 */
@Entity
/*
    - Entity : 테이블과 링크될 클래스
    - 언더스코어 네이밍으로 이름 매칭
    ex) SalesManager.java -> sales_manager table
 */
public class Posts extends BaseTimeEntity{

    @Id
    /*
        해당 테이블의 PK필드
     */
    @GeneratedValue
    /*
        - PK의 생성규칙
        - 기본값은 AUTO (MySql의 auto_increment 같은 자동 증가 정수형 값)
     */
    private Long id;
    /*
        ** Entity의 PK는 Long 타입으로 Auto increment 를 추천
        * 주민번호와 같은 비지니스상 유니크키나 여러키를 조합한 복합키로 PK를 잡을 경우 어려움 발생
        * 1) FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나 중간 테이블을 하나 더 둬야하는 상황 발생
        * 2) 인덱스에 좋은 영향을 끼치지 못함
        * 3) 유니크한 조건이 변경될 경우 PK전체를 수정해야하는 일이 발생
     */

    @Column(length = 500, nullable = false)
    /*
        - 테이블의 컬럼. 선언하지 않더라도 해당클래스의 필드는 모두 컬럼
        - 특별히 사용하는 이유는 기본 옵션 부여
     */
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;


    /*
        해당 클래스의 빌더패턴 클래스 생성
            * 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
     */
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
