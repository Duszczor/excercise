package com.nask.exercise;

import com.nask.exercise.services.CharacterService;
import com.nask.exercise.services.JsonValueService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Component
public class InitializingBeanApp implements InitializingBean {

    @Autowired
    CharacterService characterService;

    @Autowired
    JsonValueService jsonValueService;

    private static final Logger LOG
            = Logger.getLogger(InitializingBeanApp.class.getName());


    @Override
    public void afterPropertiesSet() throws Exception {
        characterService.getAllJson();
    }
}