package com.feilu.game.box.account.controller.api;


import com.feilu.game.box.account.entity.dto.XqhUserCreateDTO;
import com.feilu.game.box.account.entity.dto.XqhUserUpdateDTO;
import com.feilu.game.box.account.entity.vo.UserInfoVO;
import com.feilu.game.box.account.entity.vo.XqhUserVO;
import com.feilu.game.box.example.utils.common.PageResult;
import com.feilu.game.box.example.utils.common.ResponseBean;
import com.feilu.game.box.example.utils.common.Search;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by hssh on 2017/9/10.
 */
@RequestMapping("/xqh/ad/account/")
public interface IUserController
{

    @PutMapping
    public ResponseBean<Integer> insert(@RequestBody @Valid XqhUserCreateDTO user,
                                        HttpServletResponse resp);

    @PostMapping
    public ResponseBean<Integer> update(@RequestBody @Valid XqhUserUpdateDTO user);

    @PostMapping("list")
    public ResponseBean<PageResult<XqhUserVO>> queryList(@RequestParam("search") @NotNull Search search,
                                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                         @RequestParam(value = "size", defaultValue = "10") @Max(1000) Integer size);


    @PostMapping("/login")
    public ResponseBean<UserInfoVO> login(@RequestParam(value = "userName") String userName,
                                          @RequestParam(value = "password") String password,
                                          HttpServletResponse resp);


    @GetMapping("/info")
    public ResponseBean<UserInfoVO> info(@RequestParam(value = "token") String token);

    @PostMapping("/reset")
    public ResponseBean<Integer> reset(@RequestParam(value = "userName") String userName,
                                       @RequestParam(value = "passwordOld") String passwordOld,
                                       @RequestParam(value = "password") String password,
                                       HttpServletResponse resp);

    @PostMapping("/logout")
    public ResponseBean logout();

}
