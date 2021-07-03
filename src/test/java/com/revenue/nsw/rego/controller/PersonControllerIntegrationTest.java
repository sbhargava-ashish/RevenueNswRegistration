package com.revenue.nsw.rego.controller;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.model.Response;
import com.revenue.nsw.rego.service.PersonService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAll() {
        List<Person> personList = (List<Person>) this.restTemplate.getForObject("http://localhost:" + port + "/person/findAll",
                Object.class);
        assertNotNull(personList);
        assertEquals(1, personList.size());
    }

    @Test
    public void testAddPerson() {
        Response response = this.restTemplate.postForObject("http://localhost:" + port + "/person/add",
                new Person("Jacob", "49"), Response.class);
        assertNotNull(response);
        assertEquals(200, response.getCode());
    }

}