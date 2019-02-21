package com.feilu.game.box.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FloorStatusEnum {
    ENABLE(1, "启用"),
    DISABLE(2, "禁用"),
    ;

    private int code;
    private String name;
}
