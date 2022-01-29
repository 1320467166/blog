package com.example.blog.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.domain.entity.SysDict;
import com.example.blog.mapper.SysDictMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> {
    @Resource
    private SysDictMapper sysDictMapper;

}
