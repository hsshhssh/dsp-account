package com.feilu.game.box;

import com.feilu.game.box.example.utils.common.DozerUtils;
import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = {"com.feilu.game.box.account.tkmapper.mapper","com.feilu.game.box.example.tkmapper.mapper"})
@EnableScheduling
@ComponentScan(basePackages = {"com.feilu.game.box.account", "com.feilu.game.box.example"})
public class Application
{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public DozerBeanMapper dozerBean() {
		List<String> mappingFiles = Arrays.asList(
				"dozer/dozer-mapping.xml"
		);

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}

	@Bean
	public DozerUtils dozerUtils() {
		return new DozerUtils();
	}
}
