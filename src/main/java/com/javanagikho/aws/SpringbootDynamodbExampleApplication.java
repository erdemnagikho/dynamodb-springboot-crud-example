package com.javanagikho.aws;

import com.javanagikho.aws.entity.Person;
import com.javanagikho.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootDynamodbExampleApplication {
    @Autowired
    private PersonRepository repository;

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person) {
        return repository.addPerson(person);
    }


    @GetMapping("/getPerson/{personId}")
    public Person findPerson(@PathVariable String personId) {
        return repository.findPersonByPersonId(personId);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person) {
        return repository.deletePerson(person);
    }

    @PutMapping("/updatePerson")
    public String updatePerson(@RequestBody Person person) {
        return repository.updatePerson(person);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamodbExampleApplication.class, args);
    }
}
