package com.revenue.nsw.rego.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Vehicle implements Serializable {

    @NotNull
    private String regoNumber;

    @NotNull
    private String brand;

    private String personId;

    public Vehicle(String regoNumber, String brand) {
        this.regoNumber = regoNumber;
        this.brand = brand;
    }

    
}
