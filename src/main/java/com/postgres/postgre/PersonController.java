package com.postgres.postgre;


import com.postgres.postgre.model.Person;
import com.postgres.postgre.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class PersonController {

    @Autowired
    PersonRepo repo;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        repo.save(person);
    }

    @GetMapping("/getPerson/{id}")
    public Optional<Person> getPerson(@PathVariable Long id) {
        return repo.findById(id);
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons() {
        return repo.findAll();
    }



    // Update a person
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Person person = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));

        person.setName(personDetails.getName());

        return repo.save(person);
    }

    // Delete a person
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        Person person = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        repo.delete(person);
    }

}
