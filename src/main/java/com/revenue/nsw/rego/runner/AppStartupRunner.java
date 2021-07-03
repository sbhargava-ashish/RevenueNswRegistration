package com.revenue.nsw.rego.runner;

import com.revenue.nsw.rego.model.Person;
import com.revenue.nsw.rego.model.Vehicle;
import com.revenue.nsw.rego.service.PersonService;
import com.revenue.nsw.rego.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class AppStartupRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private VehicleService vehicleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        personService.addPerson(new Person("Ashish", "30"));
        vehicleService.addVehicle(new Vehicle("123", "Mazda"));
    }
}