package com.revenue.nsw.rego.controller;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.model.Response;
import com.revenue.nsw.rego.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping("/add")
    public Response addPerson(@Valid @RequestBody com.revenue.nsw.rego.model.Person person) {
        logger.debug("Incoming request to add person with body {}", person);
        Person savedPerson = personService.addPerson(person);
        logger.debug("person has been saved with id {}", savedPerson.getId());
        return new Response(HttpStatus.OK.value(), "Person created with id " + savedPerson.getId());
    }
 }
