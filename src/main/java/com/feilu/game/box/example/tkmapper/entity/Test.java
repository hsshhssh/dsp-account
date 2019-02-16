package com.feilu.game.box.example.tkmapper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "`t_test`")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
}