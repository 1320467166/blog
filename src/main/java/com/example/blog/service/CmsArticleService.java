package com.example.blog.service;

import com.example.blog.domain.entity.CmsArticle;
import com.example.blog.mapper.CmsArticleMapper;
import com.example.blog.mapper.CmsStarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsArticleService {
    @Resource
    private CmsArticleMapper cmsArticleMapper;

    public List<CmsArticle> findCmsArticleList(){
        List<CmsArticle> articleList = cmsArticleMapper.findCmsArticleList();
        return articleList;
    }

}
