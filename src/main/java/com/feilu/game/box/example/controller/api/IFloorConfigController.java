package com.feilu.game.box.example.controller.api;

import com.feilu.game.box.example.entity.dto.FloorConfigInsertDTO;
import com.feilu.game.box.example.entity.dto.FloorConfigUpdateDTO;
import com.feilu.game.box.example.entity.vo.FloorConfigVO;
import com.feilu.game.box.example.utils.common.PageResult;
import com.feilu.game.box.example.utils.common.ResponseBean;
import com.feilu.game.box.example.utils.common.Search;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@RestController("/feilu/game/floor")
public interface IFloorConfigController {

    @PostMapping("insert")
    public ResponseBean<Integer> insert(@RequestBody @Valid FloorConfigInsertDTO dto);

    @PostMapping("update")
    public ResponseBean<Integer> update(@RequestBody @Valid FloorConfigUpdateDTO dto);

    @PostMapping("delete")
    public ResponseBean<Integer> delete(@RequestParam("id") Integer id);

    @PostMapping("selectList")
    public ResponseBean<PageResult<FloorConfigVO>> selectList(@RequestParam("search") @NotNull Search search,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") @Max(1000) Integer size);

    @PostMapping("select")
    public ResponseBean<FloorConfigVO> select(@RequestParam("id") Integer id);
}
