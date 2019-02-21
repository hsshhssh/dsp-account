package com.feilu.game.box.example.entity.vo;

import com.feilu.game.box.example.tkmapper.entity.FloorConfig;
import lombok.Data;

@Data
public class FloorConfigVO extends FloorConfig {

    // 状态
    private String stateStr;
    // 类型
    private String typeStr;
}
