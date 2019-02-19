package com.feilu.game.box.account.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * 用户信息视图
 * Created by hssh on 2017/5/24.
 */
@Data
public class UserInfoVO
{

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户登陆名
     */
    private String userName;

    /**
     * 用户简介
     */
    private String introduction;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户角色
     */
    private List<String> roles;

    /**
     * 用户登录凭证
     */
    private String token;

    /**
     * 用户id
     */
    private Integer uid;
}
