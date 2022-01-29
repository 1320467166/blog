package com.example.blog.controller;

import com.example.blog.domain.entity.SysDict;
import com.example.blog.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysDict")
@Api(value = "字典",description = "字典")
public class SysDictController {
    @Resource
    private SysDictService sysDictService;

    @PostMapping("/add")
    @ApiOperation(value = "添加字典", notes = "添加字典")
    public ResponseEntity add(@Validated @RequestBody SysDict sysDict) {
        sysDictService.save(sysDict);
        return ResponseEntity.ok("");
    }
}