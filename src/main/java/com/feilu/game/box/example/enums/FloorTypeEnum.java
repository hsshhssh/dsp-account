package com.feilu.game.box.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FloorTypeEnum {

    SINGLE_LINE(1, "单行"),
    RIGHT_LEFT_SLIDE(2, "左右滑动"),
    MULTI_LINE(3, "多行"),
    UP_DOWN_SLIDE(4, "上下滑动"),
    ;
    private int code;
    private String name;

}
