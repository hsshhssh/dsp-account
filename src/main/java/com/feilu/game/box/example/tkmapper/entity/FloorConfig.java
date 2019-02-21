package com.feilu.game.box.example.tkmapper.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "`t_floor_config`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloorConfig {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 楼层类型
     */
    private Integer type;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 状态 1启用 2禁用
     */
    private Integer state;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;
}