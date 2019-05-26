package com.feilu.game.box.account.service;

import com.feilu.game.box.account.utils.common.ExampleBuilder;
import com.feilu.game.box.account.utils.common.Search;
import com.google.common.collect.Lists;
import com.feilu.game.box.account.entity.vo.UserInfoVO;
import com.feilu.game.box.account.tkmapper.entity.XqhUser;
import com.feilu.game.box.account.tkmapper.entity.XqhUserRole;
import com.feilu.game.box.account.tkmapper.mapper.XqhUserMapper;
import com.feilu.game.box.account.tkmapper.mapper.XqhUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hssh on 2017/9/10.
 */
@Service
public class UserService
{

    @Autowired
    private XqhUserRoleMapper xqhUserRoleMapper;
    @Resource
    private XqhUserMapper xqhUserMapper;

    /**
     * 获得用户信息对象
     * @param xqhUser
     * @return
     */
    public UserInfoVO genUserInfoVOByPayUser(XqhUser xqhUser)
    {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfoVO.setIntroduction(xqhUser.getName());
        userInfoVO.setName(xqhUser.getName());
        userInfoVO.setUserName(xqhUser.getUsername());

        // 获取角色
        Search search = new Search();
        search.put("userId_eq", xqhUser.getId());
        Example example = new ExampleBuilder(XqhUserRole.class).search(search).build();

        List<XqhUserRole> xqhUserRoleList = xqhUserRoleMapper.selectByExample(example);

        List<String> roleList = Lists.newArrayList();
        for (XqhUserRole xqhUserRole : xqhUserRoleList)
        {
            roleList.add(xqhUserRole.getRoleName());
        }

        userInfoVO.setRoles(roleList);


        userInfoVO.setToken(xqhUser.getUsername());
        userInfoVO.setUid(xqhUser.getId());

        return userInfoVO;

    }

    public XqhUser getUserById(int id)
    {
        Search search = new Search();
        search.put("id_eq", id);
        Example example = new ExampleBuilder(XqhUser.class).search(search).build();

        List<XqhUser> xqhUserList = xqhUserMapper.selectByExample(example);

        return xqhUserList.size() > 0 ? xqhUserList.get(0) : null;
    }

}
