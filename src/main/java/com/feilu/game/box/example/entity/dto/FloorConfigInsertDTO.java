package com.feilu.game.box.example.entity.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class FloorConfigInsertDTO {

    @NotBlank(message = "标题不能为空")
    @Length(max = 100, message = "标题超长")
    protected String title;

    @NotNull(message = "楼层类型不能为空")
    protected Integer type;

    @NotNull(message = "状态不能为空")
    private Integer state;

    protected Integer weight;
}
