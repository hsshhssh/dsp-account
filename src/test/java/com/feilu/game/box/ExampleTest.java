package com.feilu.game.box;


import com.feilu.game.box.example.entity.vo.FloorConfigVO;
import com.feilu.game.box.example.tkmapper.entity.FloorConfig;
import com.feilu.game.box.example.utils.common.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ExampleTest {


    @Test
    public void dbTest() {
    }

    @Test
    public void dozerTest() {
        FloorConfig config = new FloorConfig();
        config.setState(1);
        config.setType(1);
        System.out.println(DozerUtils.map(config, FloorConfigVO.class));
    }
}
