package com.betterfly.webservice.domain.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by betterFLY on 2018. 2. 7.
 * Github : http://github.com/betterfly88
 */

@Entity
public class Hello {

    @Id
    @GeneratedValue
    Long id;

    String name;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
