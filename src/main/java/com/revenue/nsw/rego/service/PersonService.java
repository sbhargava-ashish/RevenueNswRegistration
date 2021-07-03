package com.revenue.nsw.rego.service;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.repositiry.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().iterator().forEachRemaining(persons::add);
        return persons;
    }

    public Person addPerson(com.revenue.nsw.rego.model.Person person) {
        Person personEntity = new Person(person.getName(), person.getAge());
        Person savedPerson = personRepository.save(personEntity);
        return savedPerson;
    }
}
