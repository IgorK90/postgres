package com.example.postgres.Service;

import com.example.postgres.Entities.Person;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {
     Person save(Person person);
     Optional<Person> findById(Long id);
     List<Person> findAll();


}
