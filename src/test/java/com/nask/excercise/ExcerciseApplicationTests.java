package com.nask.excercise;

import com.nask.exercise.ExcerciseApplication;
import com.nask.exercise.services.CharacterService;
import com.nask.exercise.services.JsonValueService;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExcerciseApplication.class)
class ExcerciseApplicationTests {

	@Autowired
	JsonValueService service;

	@Test
	void contextLoads() {
		CharacterService cs = new CharacterService();
		cs.getAllJson(service);

		Assert.assertTrue(true);
	}



}
