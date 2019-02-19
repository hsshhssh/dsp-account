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

@Table(name = "`t_content_floor_config`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentFloorConfig {
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
     * 内容id
     */
    @Column(name = "content_id")
    private Integer contentId;

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