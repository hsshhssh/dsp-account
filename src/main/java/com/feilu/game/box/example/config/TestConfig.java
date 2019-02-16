package com.feilu.game.box.example.config;

import org.hssh.common.zkconf.Value;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {

    @Value(path = "test.conf", key="aa")
    public String aa;
}
