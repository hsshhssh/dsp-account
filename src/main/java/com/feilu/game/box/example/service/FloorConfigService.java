package com.feilu.game.box.example.service;

import com.feilu.game.box.example.tkmapper.entity.ContentFloorConfig;
import com.feilu.game.box.example.tkmapper.entity.FloorConfig;
import com.feilu.game.box.example.tkmapper.entity.GameFloorConfig;
import com.feilu.game.box.example.tkmapper.mapper.ContentFloorConfigMapper;
import com.feilu.game.box.example.tkmapper.mapper.FloorConfigMapper;
import com.feilu.game.box.example.tkmapper.mapper.GameFloorConfigMapper;
import com.feilu.game.box.example.utils.common.ExampleBuilder;
import com.feilu.game.box.example.utils.common.Search;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FloorConfigService {

    @Autowired
    private FloorConfigMapper floorConfigMapper;
    @Autowired
    private GameFloorConfigMapper gameFloorConfigMapper;
    @Autowired
    private ContentFloorConfigMapper contentFloorConfigMapper;

    @Transactional
    public void deleteFloor(FloorConfig floorConfig, List<GameFloorConfig> gameFloorConfigList, List<ContentFloorConfig> contentFloorConfigList) {
        floorConfigMapper.deleteByPrimaryKey(floorConfig.getId());

        if (CollectionUtils.isNotEmpty(gameFloorConfigList)) {
            List<Integer> idList = gameFloorConfigList.stream().map(GameFloorConfig::getId).collect(Collectors.toList());
            Search search = new Search();
            search.put("id_in", idList);
            gameFloorConfigMapper.deleteByExample(new ExampleBuilder(GameFloorConfig.class).search(search).build());
        }

        if (CollectionUtils.isNotEmpty(contentFloorConfigList)) {
            List<Integer> idList = contentFloorConfigList.stream().map(ContentFloorConfig::getId).collect(Collectors.toList());
            Search search = new Search();
            search.put("id_in", idList);
            contentFloorConfigMapper.deleteByExample(new ExampleBuilder(ContentFloorConfig.class).search(search).build());
        }

    }
}
