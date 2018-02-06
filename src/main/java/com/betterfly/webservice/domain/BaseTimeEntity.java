package com.betterfly.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */


@Getter
@MappedSuperclass
/*
    JAP Entity 클래스들이 BaseTimeEntity상속할 경우 해당 컬럼으로 인식
 */
@EntityListeners(AuditingEntityListener.class)
/*
    BaseTimeEntity 클래스에 Auditing 기능 포함
    > Application에서 @EnabledJpaAduting 으로 활성화 시켜줌
 */
public abstract class BaseTimeEntity {

    @CreatedDate
    /*
        Entity가 생성되어 저장될 때 시간 자동 저장
     */
    private LocalDateTime createdDate;

    @LastModifiedDate
    /*
        조회한 Entity의 값이 변경될때 시간 자동 저장
     */
    private LocalDateTime modifiedDate;
}
