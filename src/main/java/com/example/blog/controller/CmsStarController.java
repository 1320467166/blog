package com.example.blog.controller;

import com.example.blog.domain.dto.IdDTO;
import com.example.blog.domain.entity.CmsStar;
import com.example.blog.service.CmsStarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/cmsStart")
@Api(value = "点赞",description = "点赞控制器")
public class CmsStarController {
    @Resource
    private CmsStarService cmsStarService;

    @ApiOperation(value = "新增个人点赞记录",notes = "新增个人点赞记录")
    public ResponseEntity query(IdDTO idDTO){
        cmsStarService.query(idDTO);
        return ResponseEntity.ok("新增个人点赞记录成功");
    }
}
