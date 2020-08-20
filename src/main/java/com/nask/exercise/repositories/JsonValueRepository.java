package com.nask.exercise.repositories;

import com.nask.exercise.models.JsonValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsonValueRepository extends CrudRepository<JsonValues, Integer> {

    Page<JsonValues> findAll(Pageable pageable);

}