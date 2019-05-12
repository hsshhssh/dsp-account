package com.feilu.game.box.account.controller.impl;


import com.feilu.game.box.account.controller.api.IUserController;
import com.feilu.game.box.account.utils.common.*;
import com.feilu.game.box.account.utils.enums.ResponseEnum;
import com.github.pagehelper.Page;
import com.feilu.game.box.account.entity.dto.XqhUserCreateDTO;
import com.feilu.game.box.account.entity.dto.XqhUserUpdateDTO;
import com.feilu.game.box.account.entity.vo.UserInfoVO;
import com.feilu.game.box.account.entity.vo.XqhUserVO;
import com.feilu.game.box.account.service.UserService;
import com.feilu.game.box.account.tkmapper.entity.XqhUser;
import com.feilu.game.box.account.tkmapper.mapper.XqhUserMapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hssh on 2017/9/10.
 */
@RestController
public class UserController implements IUserController
{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private XqhUserMapper xqhUserMapper;

    @Autowired
    private UserService userService;

    @Override
    public ResponseBean<Integer> insert(@RequestBody @Valid XqhUserCreateDTO user, HttpServletResponse resp)
    {
        return new ResponseBean<>(0);
    }

    @Override
    public ResponseBean<Integer> update(@RequestBody @Valid XqhUserUpdateDTO user) {
        return new ResponseBean<>(0);
    }

    @Override
    public ResponseBean<PageResult<XqhUserVO>> queryList(@RequestParam("search") @NotNull Search search,
                                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                         @RequestParam(value = "size", defaultValue = "10") @Max(1000) Integer size)
    {
        Example example = new ExampleBuilder(XqhUser.class).search(search).sort(Arrays.asList("id_desc")).build();

        Page<XqhUser> payUserList = (Page<XqhUser>) xqhUserMapper.selectByExampleAndRowBounds(example, new RowBounds(page, size));

        PageResult<XqhUserVO> result = new PageResult<>(payUserList.getTotal(), DozerUtils.mapList(payUserList, XqhUserVO.class));
        return new ResponseBean<>(result);
    }

    @Override
    public ResponseBean<UserInfoVO> login(@RequestParam(value = "username") String userName,
                            @RequestParam(value = "password") String password,
                            HttpServletResponse resp)
    {
        Search search = new Search();
        search.put("username_eq", userName);
        Example example = new ExampleBuilder(XqhUser.class).search(search).build();

        List<XqhUser> xqhUserList = xqhUserMapper.selectByExample(example);

        if(xqhUserList.size() != 1)
        {
            logger.error("登录失败 用户不存在 userName:{}", userName);
            return new ResponseBean<>(ResponseEnum.ERROR_USER_PASSWORD);
        }


        XqhUser xqhUser = xqhUserList.get(0);
        if(!CommonUtils.getMd5(password).equals(xqhUser.getPassword()))
        {
            logger.error("登录失败 密码错误 useName:{}, password:{}", userName, password);
            return new ResponseBean<>(ResponseEnum.ERROR_USER_PASSWORD);
        }

        // 登录成功 返回用户信息
        return new ResponseBean<>(userService.genUserInfoVOByPayUser(xqhUser));
    }

    @Override
    public ResponseBean<UserInfoVO> info(@RequestParam(value = "token") String token)
    {
        Search search = new Search();
        search.put("username_eq", token);
        Example example = new ExampleBuilder(XqhUser.class).search(search).build();

        List<XqhUser> xqhUserList = xqhUserMapper.selectByExample(example);

        return new ResponseBean<>(userService.genUserInfoVOByPayUser(xqhUserList.get(0)));
    }

    @Override
    public ResponseBean<Integer> reset(@RequestParam(value = "userName") String userName,
                     @RequestParam(value = "passwordOld") String passwordOld,
                     @RequestParam(value = "password") String password, HttpServletResponse resp)
    {
        Search search = new Search();
        search.put("username_eq", userName);
        Example example = new ExampleBuilder(XqhUser.class).search(search).build();

        List<XqhUser> payUserList = xqhUserMapper.selectByExample(example);

        if(payUserList.size() != 1)
        {
            return new ResponseBean<>(ResponseEnum.ERROR_USER_PASSWORD);
        }

        XqhUser payUser = payUserList.get(0);
        if(!CommonUtils.getMd5(passwordOld).equals(payUser.getPassword()))
        {
            return new ResponseBean<>(ResponseEnum.ERROR_USER_PASSWORD);
        }

        // 重置密码
        XqhUser record = new XqhUser();
        record.setId(payUser.getId());
        record.setPassword(CommonUtils.getMd5(password));
        xqhUserMapper.updateByPrimaryKeySelective(record);

        return new ResponseBean<>(1);
    }

    @Override
    public ResponseBean logout() {
        return new  ResponseBean(ResponseEnum.SUCCESS);
    }


}
