package com.feilu.game.box.example.tkmapper.mapper;

import com.feilu.game.box.example.tkmapper.entity.Test;
import tk.mybatis.mapper.common.Mapper;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface TestMapper extends Mapper<Test> {

    public Test selectTest(Integer id);

}




