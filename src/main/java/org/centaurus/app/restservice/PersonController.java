package org.centaurus.app.restservice;

import org.centaurus.app.models.Person;
import org.centaurus.app.repository.modelRepository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("person")
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        logger.info("");
        return personRepository.save(person);
    }

    @GetMapping("{email}/{password}")
    public Person findPersonByEmailAndPAssword(@PathVariable String email, @PathVariable String password) {
        return personRepository.findByEmailAndPassword(email, password);
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable Integer id) {
        return personRepository.findById(id);
    }

    @GetMapping
    public Set<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @DeleteMapping("{email}/{password}")
    public void deleteByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        personRepository.deleteByEmailAndPassword(email, password);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return personRepository.update(person);
    }

}
