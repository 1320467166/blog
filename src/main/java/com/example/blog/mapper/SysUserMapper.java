package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.domain.dto.sysUser.UserQueryDTO;
import com.example.blog.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectByUserName(@Param("userName") String userName);

    List<SysUser> selectByPage(@Param("queryDTO") UserQueryDTO queryDTO);
}
