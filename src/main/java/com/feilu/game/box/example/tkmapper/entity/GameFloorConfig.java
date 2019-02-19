package com.feilu.game.box.example.tkmapper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`t_game_floor_config`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameFloorConfig {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 楼层id
     */
    @Column(name = "floor_id")
    private Integer floorId;

    /**
     * 游戏id
     */
    @Column(name = "game_id")
    private Integer gameId;

    /**
     * 跳转类型 1跳转到图片 2跳转到小程序
     */
    private Integer type;

    /**
     * 权重
     */
    private Integer weight;

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