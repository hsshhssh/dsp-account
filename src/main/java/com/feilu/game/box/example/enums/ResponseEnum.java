package com.feilu.game.box.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS("20000", "成功"),

    ERROR_USER_PASSWORD("10000", "用户名或密码错误"),
    ERROR_PARAM("100001", "参数校验失败"),

    ;

    private String code;
    private String message;


}
