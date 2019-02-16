package com.feilu.game.box;


import com.feilu.game.box.example.tkmapper.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class ExampleTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void dbTest() {
        System.out.println(testMapper.selectAll());
        System.out.println(testMapper.selectTest(1));
    }
}
