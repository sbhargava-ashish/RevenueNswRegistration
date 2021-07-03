package com.revenue.nsw.rego.controller;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.model.Response;
import com.revenue.nsw.rego.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Test
    public void testFindAll() {
        when(personService.findAll()).thenReturn(getDummyPersons());
        List<Person> personList = personController.findAll();
        assertNotNull(personList);

    }

    @Test
    public void testAddPerson() {
        com.revenue.nsw.rego.model.Person person = new com.revenue.nsw.rego.model.Person();
        when(personService.addPerson(any(com.revenue.nsw.rego.model.Person.class)))
                .thenReturn(new Person("Ashish", "30"));
        Response response = personController.addPerson(person);
        assertEquals(200, response.getCode());

    }

    private List<Person> getDummyPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ashish", "30"));
        persons.add(new Person("Jacob", "30"));
        return persons;
    }
}