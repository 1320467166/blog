package com.example.blog.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.domain.dto.IdDTO;
import com.example.blog.domain.entity.CmsStar;
import com.example.blog.mapper.CmsStarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CmsStarService extends ServiceImpl<CmsStarMapper, CmsStar> {
    @Resource
    private CmsStarMapper cmsStarMapper;

    //分页查询
    public void query(IdDTO idDTO) {

    }
}
