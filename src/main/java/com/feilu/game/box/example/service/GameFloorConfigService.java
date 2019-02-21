package com.feilu.game.box.example.service;

import com.feilu.game.box.example.tkmapper.entity.GameFloorConfig;
import com.feilu.game.box.example.tkmapper.mapper.GameFloorConfigMapper;
import com.feilu.game.box.example.utils.common.ExampleBuilder;
import com.feilu.game.box.example.utils.common.Search;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Service
public class GameFloorConfigService {

    @Autowired
    private GameFloorConfigMapper gameFloorConfigMapper;

    public List<GameFloorConfig> getByFloorId(Integer floorId) {
        Search search = new Search();
        search.put("floorId_eq", floorId);
        Example example = new ExampleBuilder(GameFloorConfig.class).search(search).build();

        return gameFloorConfigMapper.selectByExample(example);
    }
}
