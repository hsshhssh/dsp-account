package com.feilu.game.box.example.controller.impl;

import com.feilu.game.box.example.controller.api.IFloorConfigController;
import com.feilu.game.box.example.entity.dto.FloorConfigInsertDTO;
import com.feilu.game.box.example.entity.dto.FloorConfigUpdateDTO;
import com.feilu.game.box.example.entity.vo.FloorConfigVO;
import com.feilu.game.box.example.enums.FloorStatusEnum;
import com.feilu.game.box.example.enums.ResponseEnum;
import com.feilu.game.box.example.service.ContentFloorConfigService;
import com.feilu.game.box.example.service.FloorConfigService;
import com.feilu.game.box.example.service.GameFloorConfigService;
import com.feilu.game.box.example.tkmapper.entity.ContentFloorConfig;
import com.feilu.game.box.example.tkmapper.entity.FloorConfig;
import com.feilu.game.box.example.tkmapper.entity.GameFloorConfig;
import com.feilu.game.box.example.tkmapper.mapper.FloorConfigMapper;
import com.feilu.game.box.example.utils.common.*;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class FloorConfigController implements IFloorConfigController {

    @Autowired
    private FloorConfigMapper floorConfigMapper;
    @Autowired
    private GameFloorConfigService gameFloorConfigService;
    @Autowired
    private ContentFloorConfigService contentFloorConfigService;
    @Autowired
    private FloorConfigService floorConfigService;


    @Override
    public ResponseBean<Integer> insert(@RequestBody @Valid FloorConfigInsertDTO dto) {
        FloorConfig floorConfig = new FloorConfig();
        floorConfig.setTitle(dto.getTitle());
        floorConfig.setType(dto.getType());
        floorConfig.setWeight(dto.getWeight());
        floorConfig.setState(FloorStatusEnum.ENABLE.getCode());

        int id = floorConfigMapper.insert(floorConfig);
        return new ResponseBean<>(id);
    }

    @Override
    public ResponseBean<Integer> update(@RequestBody @Valid FloorConfigUpdateDTO dto) {
        FloorConfig floorConfig = floorConfigMapper.selectByPrimaryKey(dto.getId());
        if (null == floorConfig) {
            return new ResponseBean<>(ResponseEnum.ERROR_FLOOR_ID);
        }

        FloorConfig updateRecord = DozerUtils.map(dto, FloorConfig.class);
        int res = floorConfigMapper.updateByPrimaryKeySelective(updateRecord);
        return new ResponseBean<>(res);
    }

    @Override
    public ResponseBean<Integer> delete(Integer id) {
        // 查询楼层配置表
        FloorConfig floorConfig = floorConfigMapper.selectByPrimaryKey(id);
        if (null == floorConfig) {
            return new ResponseBean<>(ResponseEnum.ERROR_FLOOR_ID);
        }

        // 查询游戏楼层配置
        List<GameFloorConfig> gameFloorConfigList = gameFloorConfigService.getByFloorId(id);

        // 查询内容楼层配置
        List<ContentFloorConfig> contentFloorConfigList = contentFloorConfigService.getByFloorId(id);

        // 删除
        try {
            floorConfigService.deleteFloor(floorConfig, gameFloorConfigList, contentFloorConfigList);
        } catch (Exception e) {
            log.error("删除楼层-操作失败 id:{}", id);
            return new ResponseBean<>(ResponseEnum.ERROR_FALI);
        }

        return new ResponseBean<>(1);
    }

    @Override
    public ResponseBean<PageResult<FloorConfigVO>> selectList(@RequestParam("search") @NotNull Search search,
                                                              @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "size", defaultValue = "10") @Max(1000) Integer size) {
        Example example = new ExampleBuilder(FloorConfig.class).search(search).sort(Collections.singletonList("id_desc")).build();
        Page<FloorConfig> floorConfigPage = (Page<FloorConfig>) floorConfigMapper.selectByExampleAndRowBounds(example, new RowBounds(page, size));
        return new ResponseBean<>(new PageResult<>(floorConfigPage.getTotal(), DozerUtils.mapList(floorConfigPage.getResult(), FloorConfigVO.class)));
    }

    @Override
    public ResponseBean<FloorConfigVO> select(@RequestParam("id") Integer id) {
        // 查询楼层配置表
        FloorConfig floorConfig = floorConfigMapper.selectByPrimaryKey(id);
        if (null == floorConfig) {
            return new ResponseBean<>(ResponseEnum.ERROR_FLOOR_ID);
        }

        return new ResponseBean<>(DozerUtils.map(floorConfig, FloorConfigVO.class));
    }

}
