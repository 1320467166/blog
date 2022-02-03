package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.domain.entity.SysUser;
import com.example.blog.domain.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectByUserName(@Param("userName") String userName);
    SysUserVO selectNickNameById();
}
