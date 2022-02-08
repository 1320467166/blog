package com.example.blog.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author
 */
@Data
public class VacTask {

    private String id;
    private String name;
//    private Vacation vac;
    private Date createTime;

    // getter setter ...
}