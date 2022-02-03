package com.example.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.blog.domain.dto.SysUserDTO.UserForgetDTO;
import com.example.blog.domain.dto.SysUserDTO.UserRegisterDTO;
import com.example.blog.domain.dto.SysUserDTO.UserUpdateDTO;
import com.example.blog.domain.entity.SysUser;
import com.example.blog.domain.vo.SysUserVO;
import com.example.blog.exceptions.BusinessException;
import com.example.blog.mapper.SysUserMapper;
import com.example.blog.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/sysUser")
@Api(value = "系统用户管理",description = "系统用户管理")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysUserMapper sysUserMapper;

    @PostMapping("/register")
    @ApiOperation(value = "注册用户",notes = "注册用户")
    public ResponseEntity register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        sysUserService.register(userRegisterDTO);
        return ResponseEntity.ok("注册成功");
    }

    @PostMapping("/forget")
    @ApiOperation(value = "忘记密码",notes = "忘记密码")
    public ResponseEntity forget(@Validated @RequestBody UserForgetDTO userForgetDTO) {
        sysUserService.forget(userForgetDTO);
        return ResponseEntity.ok("");
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息")
    public ResponseEntity update(@RequestBody UserUpdateDTO userUpdateDTO) {
        sysUserService.update(userUpdateDTO);
        return ResponseEntity.ok("修改成功");
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登入",notes = "用户登入")
    public ResponseEntity update(@RequestBody SysUser sysUser) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName,sysUser.getUserName())
                        .eq(SysUser::getPassword,sysUser.getPassword());
        if (ObjectUtils.isEmpty(sysUserService.getOne(queryWrapper))) {
            throw new BusinessException("登入失败");
        }
        return ResponseEntity.ok("登录成功");
    }

    @GetMapping("/logout")
    @ApiOperation(value = "用户登出",notes = "用户登出")
    public ResponseEntity logout() {
        return ResponseEntity.ok("登出成功");
    }

    @GetMapping("/get")
    public SysUserVO get(){
        return sysUserMapper.selectNickNameById();
    }
}
