package com.example;

import org.antonu.bowling.rest.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class RestApiTests {

	@Test
	public void contextLoads() {
	}

}
