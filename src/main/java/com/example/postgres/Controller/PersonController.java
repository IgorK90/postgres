package com.example.postgres.Controller;


import com.example.postgres.Service.PersonService;
import com.example.postgres.Dto.PersonDTO;
import com.example.postgres.Entities.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;
    public PersonController (PersonService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonDTO dto)
    {
        Person person = Person.builder()
                .Name((String) dto.getName())
                .email(dto.getEmail())
                .build();
        Person persistentPerson = service.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(persistentPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id)
    {
        Optional<Person> personOpt = service.findById(id);

        if (personOpt.isPresent())
            return ResponseEntity.ok(personOpt.get());
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

}
