package com.revenue.nsw.rego.controller;

import com.revenue.nsw.rego.exception.ValidationException;
import com.revenue.nsw.rego.entity.Vehicle;
import com.revenue.nsw.rego.model.Response;
import com.revenue.nsw.rego.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/findAll")
    public List<Vehicle> findAll() {
        logger.debug("Incoming request received to find all vehicles");
        return vehicleService.findAll();
    }

    @PostMapping("/add")
    public Response addVehicle(@Valid @RequestBody com.revenue.nsw.rego.model.Vehicle vehicle) {
        logger.debug("Incoming request received to add vehicle with body {}" , vehicle);
        Vehicle vehicleEntity = vehicleService.addVehicle(vehicle);
        logger.debug("Outgoing response with body {}" , vehicleEntity);
        return new Response(HttpStatus.OK.value(), "Vehicle created with id " + vehicleEntity.getId());
    }

    @PutMapping("/link")
    public Response linkPersonToVehicleById(@NotNull @RequestParam String regoNumber ,
                                            @NotNull @RequestParam String personId) {
        logger.debug("Incoming request to link vehicle with id to person with id {}" , regoNumber, personId);
        try {
            vehicleService.link(regoNumber, personId);
            logger.debug("Request completed");
        } catch (ValidationException ex) {
            return new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        } catch (Exception ex) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
        return new Response(HttpStatus.OK.value(), "person linked to vehicle completed");
    }

    @PutMapping("/unlink")
    public Response unlinkPersonToVehicleById(@NotNull @RequestParam String regoNumber ,
                                            @NotNull @RequestParam String personId) {
        logger.debug("Incoming request to link vehicle with id to person with id {}" , regoNumber, personId);
        try {
            vehicleService.unlink(regoNumber, personId);
            logger.debug("Request completed");
        } catch (ValidationException ex) {
            return new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        } catch (Exception ex) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
        return new Response(HttpStatus.OK.value(), "person unlink to vehicle completed");
    }
 }
