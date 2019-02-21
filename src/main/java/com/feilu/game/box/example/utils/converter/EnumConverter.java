package com.feilu.game.box.example.utils.converter;

import com.feilu.game.box.example.enums.FloorStatusEnum;
import com.feilu.game.box.example.enums.FloorTypeEnum;
import org.dozer.CustomConverter;

import java.util.Objects;

/**
 * Created by hssh on 2017/9/10.
 */
public class EnumConverter
{
    /**
     * 楼层状态
     */
    public static class FloorStatusConverter implements CustomConverter {
        @Override
        public Object convert(Object o, Object o1, Class<?> aClass, Class<?> aClass1) {
            for (FloorStatusEnum statusEnum : FloorStatusEnum.values()) {
                if (Objects.equals(statusEnum.getCode(), o1)) {
                    return statusEnum.getName();
                }
            }
            return "";
        }
    }

    /**
     * 楼层类型
     */
    public static class FloorTypeConverter implements CustomConverter {
        @Override
        public Object convert(Object o, Object o1, Class<?> aClass, Class<?> aClass1) {
            for (FloorTypeEnum typeEnum : FloorTypeEnum.values()) {
                if (Objects.equals(typeEnum.getCode(), o1)) {
                    return typeEnum.getName();
                }
            }
            return "";
        }
    }

}
