package com.example.blog.controller;

import com.example.blog.domain.entity.CmsArticle;
import com.example.blog.mapper.CmsArticleMapper;
import com.example.blog.service.CmsArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/cmsArticle")
public class CmsArticleController {
    @Resource
    private CmsArticleService cmsArticleService;

    @GetMapping("/get")
    public List<CmsArticle> findCmsArticleList(){
        return cmsArticleService.findCmsArticleList();
    }

}
