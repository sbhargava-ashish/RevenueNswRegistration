package com.revenue.nsw.rego.service;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.repositiry.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void testFindAllSuccess() {
        when(personRepository.findAll()).thenReturn(getDummyPersons());
        List<Person> personList = personService.findAll();
        assertEquals(1, personList.size());
    }

    @Test(expected = RuntimeException.class)
    public void testFindAllException() {
        when(personRepository.findAll()).thenThrow(new RuntimeException("exception occurred"));
        List<Person> personList = personService.findAll();
    }

    private Iterable<Person> getDummyPersons() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Ashish", "30"));
        return list;
    }
}