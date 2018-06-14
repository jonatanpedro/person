package com.example.datamock.controller;

import com.example.datamock.entity.Person;
import com.example.datamock.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    @RequestMapping("/people")
    public ResponseEntity saveArrayPerson(@RequestBody List<Person> people){
        personRepository.saveAll(people);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity all(){
        return ResponseEntity.ok(personRepository.findAll());
    }

}
