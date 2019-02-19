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

@Table(name = "`t_game`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 游戏分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 游戏名称
     */
    private String name;

    /**
     * 游戏图标
     */
    private String icon;

    /**
     * 游戏图片
     */
    private String picture;

    /**
     * appId
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 小程序跳转路径
     */
    private String path;

    /**
     * 小程序跳转扩展参数
     */
    @Column(name = "extra_data")
    private String extraData;

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