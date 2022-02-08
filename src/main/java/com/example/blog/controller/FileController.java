package com.example.blog.controller;

import com.example.blog.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@Api(description = "文件上传")
public class FileController {
    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/upFile")
    public ResponseEntity upFile(MultipartFile file) throws IOException {
       String url = FileUtil.uploadFile(file);
       return ResponseEntity.ok(url);
    }
}
