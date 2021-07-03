package com.revenue.nsw.rego.controller;

import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.model.Response;
import com.revenue.nsw.rego.model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAll() {
        List<Person> personList = (List<Person>) this.restTemplate.getForObject("http://localhost:" + port + "/vehicle/findAll",
                Object.class);
        assertNotNull(personList);
        assertEquals(1, personList.size());
    }

    @Test
    public void testAddVehicle() {
        Response response = this.restTemplate.postForObject("http://localhost:" + port + "/vehicle/add",
                new Vehicle("789", "Mazda"), Response.class);
        assertNotNull(response);
        assertEquals(200, response.getCode());
    }

}