package com.feilu.game.box.example.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FloorConfigUpdateDTO extends FloorConfigInsertDTO{

    @NotNull(message = "请选择楼层")
    private Integer id;
}
