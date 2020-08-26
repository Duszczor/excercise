package com.nask.exercise;

import com.nask.exercise.models.JsonValues;
import com.nask.exercise.repositories.JsonValueRepository;
import com.nask.exercise.services.CharacterService;
import com.nask.exercise.services.JsonValueService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExerciseApplicationTests.class)
class ExerciseApplicationTests {

    @Autowired
    JsonValueService service;

    @Autowired
    JsonValueRepository repository;

    @Test
    void contextLoads() {
        CharacterService cs = new CharacterService();
        cs.getAllJson();

        Assert.assertTrue(true);
    }

    @Test
    void databaseLoadTest() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<JsonValues> listToReturn = repository.findAll(pageable);

        Assert.assertFalse(listToReturn == null);
        Assert.assertFalse(listToReturn.isEmpty());
    }


}
