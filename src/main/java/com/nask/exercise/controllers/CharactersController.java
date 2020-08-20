package com.nask.exercise.controllers;

import com.nask.exercise.models.JsonValues;
import com.nask.exercise.repositories.JsonValueRepository;
import com.nask.exercise.services.CharacterService;
import com.nask.exercise.services.JsonValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CharactersController {

    @Autowired
    JsonValueRepository repository;

    @Autowired
    CharacterService characterService;

    @Autowired
    JsonValueService jsonValueService;

    @GetMapping(path = "/characters", produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity<Page<JsonValues>> getAllCharacters(@PageableDefault(size = 2, sort = "id") Pageable pageable) {
        Page<JsonValues> listToReturn = repository.findAll(pageable);
        return new ResponseEntity<>(listToReturn, HttpStatus.OK);
    }

    @GetMapping(path = "/characters/{id}", produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity<?> getCharacterById(@PathVariable("id") Integer id) {
        Optional<JsonValues> jsonValOpt = repository.findById(id);

        if (jsonValOpt.isPresent()) {
            return new ResponseEntity<>(jsonValOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Nie znaleziono bohatera o ID = " + id, HttpStatus.OK);
        }

    }


}
