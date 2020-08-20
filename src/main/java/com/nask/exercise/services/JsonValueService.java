package com.nask.exercise.services;

import java.util.ArrayList;
import java.util.List;

import com.nask.exercise.models.JsonValues;
import com.nask.exercise.repositories.JsonValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonValueService {

    @Autowired
    JsonValueRepository repository;

    public void save(final JsonValues jsonValue) {
        repository.save(jsonValue);
    }

    public List<JsonValues> getAll() {
        final List<JsonValues> jsonValues = new ArrayList<>();
        repository.findAll().forEach(jsonValues::add);
        return jsonValues;
    }
}