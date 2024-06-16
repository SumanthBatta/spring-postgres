package com.postgres.postgre;


import com.postgres.postgre.model.Person;
import com.postgres.postgre.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepo repo;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        repo.save(person);
    }

}
