package com.example.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.domain.entity.ToEmail;
import com.example.blog.domain.dto.email.EmailDTO;
import com.example.blog.domain.dto.sysUser.UserForgetDTO;
import com.example.blog.domain.dto.sysUser.UserQueryDTO;
import com.example.blog.domain.dto.sysUser.UserRegisterDTO;
import com.example.blog.domain.dto.sysUser.UserUpdateDTO;
import com.example.blog.domain.entity.SysUser;
import com.example.blog.exceptions.BusinessException;
import com.example.blog.mapper.SysUserMapper;
import com.example.blog.utils.CodeUtil;
import com.example.blog.utils.MailUtil;
import com.example.blog.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private MailUtil mailUtil;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private CodeUtil codeUtil;

    public void register(UserRegisterDTO userRegisterDTO) {
        //用户名唯一性校验
        if (!ObjectUtils.isEmpty(sysUserMapper.selectByUserName(userRegisterDTO.getUserName()))) {
            throw new BusinessException("该用户名已被使用，请重新输入！");
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", userRegisterDTO.getPhone());
        if (!ObjectUtils.isEmpty(sysUserMapper.selectOne(queryWrapper))) {
            throw new BusinessException("该手机号已被使用，请重新输入！");
        }
        //校验用户验证码
        Object code = redisUtil.get(userRegisterDTO.getEmail()[0]);
        if (ObjectUtils.isEmpty(code)){
            throw new BusinessException("验证码已过期，请重新发送");
        }
        if (code.equals(userRegisterDTO.getCode())) {
            //新增数据库操作
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(userRegisterDTO, sysUser);
            sysUserMapper.insert(sysUser);
            redisUtil.expire(userRegisterDTO.getEmail()[0]);
        }else {
            throw new BusinessException("您输入的验证码有误，请重新输入");
        }
    }

    public void validate(EmailDTO emailDTO) {
        //短信或者邮箱校验
        //生成验证码，并存入redis，设置过期时间60s
        String code = codeUtil.codeGenerate();
        redisUtil.set(emailDTO.getEmail()[0],code,300L);
        //生成邮件信息
        ToEmail toEmail = new ToEmail();
        toEmail.setContent(code +",验证码有效期为3分钟,请抓紧时间注册");
        toEmail.setSubject("注册验证码");
        toEmail.setTos(emailDTO.getEmail());
        mailUtil.commonEmail(toEmail);
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

    public List<SysUser> selectByPage(UserQueryDTO queryDTO) {
        return sysUserMapper.selectByPage(queryDTO);
    }
}
