package com.revenue.nsw.rego.service;

import com.revenue.nsw.rego.exception.ValidationException;
import com.revenue.nsw.rego.entity.Person;
import com.revenue.nsw.rego.entity.Vehicle;
import com.revenue.nsw.rego.repositiry.PersonRepository;
import com.revenue.nsw.rego.repositiry.VehicleRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepositiry vehicleRepositiry;

    @Autowired
    private PersonRepository personRepository;

    public List<Vehicle> findAll() {
        List<Vehicle> vehicleList = new ArrayList<>();
        Iterable<Vehicle> vehicles = vehicleRepositiry.findAll();
        vehicles.iterator().forEachRemaining(vehicleList::add);
        return vehicleList;
    }

    public Vehicle addVehicle(com.revenue.nsw.rego.model.Vehicle vehicle) {
        Optional<Person> person = null;
        Vehicle vehicleEntity = null;
        if (StringUtils.hasText(vehicle.getPersonId())) {
            person = personRepository.findById(Long.valueOf(vehicle.getPersonId()));
        }

        if (person != null && person.isPresent()) {
            vehicleEntity = vehicleRepositiry.save(new Vehicle(vehicle.getRegoNumber(),
                    vehicle.getBrand()));
            Person personEntity = person.get();
            personEntity.getVehicles().add(vehicleEntity);
            personRepository.save(personEntity);
        } else {
            vehicleEntity = vehicleRepositiry.save(new Vehicle(vehicle.getRegoNumber(), vehicle.getBrand()));
        }

        return vehicleEntity;
    }

    public void link(String regoNumber, String personId) {
        Optional<Person> persistedPerson = personRepository.findById(Long.valueOf(personId));
        if (persistedPerson.isPresent()) {
            Vehicle vehicle = vehicleRepositiry.findByRegoNumber(regoNumber);
            if (vehicle != null) {
                Person person = persistedPerson.get();
                person.getVehicles().add(vehicle);
                personRepository.save(person);
            } else {
                throw new ValidationException("Vehicle does not exist with id " + regoNumber);
            }
        } else {
            throw new ValidationException("Person does not exist with id " + personId);
        }

    }

    public void unlink(String regoNumber, String personId) {
        Optional<Person> persistedPerson = personRepository.findById(Long.valueOf(personId));
        if (persistedPerson.isPresent()) {
            Person person = persistedPerson.get();
            List<Vehicle> personVehicles = person.getVehicles();
            personVehicles.removeIf(vehicle -> vehicle.getRegoNumber().equals(regoNumber));
            person.setVehicles(personVehicles);
            personRepository.save(person);
        } else {
            throw new ValidationException("Person does not exist with id " + personId);
        }
    }
}
