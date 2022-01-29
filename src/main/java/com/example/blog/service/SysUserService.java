package com.example.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.domain.dto.SysUserDTO.UserForgetDTO;
import com.example.blog.domain.dto.SysUserDTO.UserRegisterDTO;
import com.example.blog.domain.dto.SysUserDTO.UserUpdateDTO;
import com.example.blog.domain.entity.SysUser;
import com.example.blog.exceptions.BusinessException;
import com.example.blog.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
    @Resource
    private SysUserMapper sysUserMapper;

    public void register(UserRegisterDTO userRegisterDTO) {
        //用户名唯一性校验
        if (!ObjectUtils.isEmpty(sysUserMapper.selectByUserName(userRegisterDTO.getUserName()))) {
            throw new BusinessException("该用户名已被使用，请重新输入！");
        }
        //Todo 短信或者邮箱校验
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userRegisterDTO.getPhone());
        if (!ObjectUtils.isEmpty(sysUserMapper.selectOne(queryWrapper))) {
            throw new BusinessException("该手机号已被使用，请重新输入！");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userRegisterDTO, sysUser);
        sysUserMapper.insert(sysUser);
    }

    public void forget(UserForgetDTO userForgetDTO) {
        //Todo 短信或者邮箱校验
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userForgetDTO.getPhone())
                .eq("userName",userForgetDTO.getUserName());
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (!sysUser.getPhone().equals(userForgetDTO.getPhone())) {
            throw new BusinessException("输入手机号非此用户绑定手机号，请重新输入！");
        }
        BeanUtils.copyProperties(userForgetDTO, sysUser);
        sysUserMapper.updateById(sysUser);
    }

    public void update(UserUpdateDTO userUpdateDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userUpdateDTO,sysUser);
        //电话号码更改需校验
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getId,userUpdateDTO.getId());
        //原用户信息
        SysUser sysUserEntity = this.getOne(queryWrapper);
        //发送短信 TODO
        sysUserMapper.updateById(sysUser);
    }
}
