package com.revenue.nsw.rego.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "vehicle",
        uniqueConstraints={@UniqueConstraint(columnNames={"REGO_NUMBER"})
})
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "REGO_NUMBER")
    private String regoNumber;

    private String brand;

    public Vehicle (){}

    public Vehicle(String regoNumber, String brand) {
        this.regoNumber = regoNumber;
        this.brand = brand;
    }

}
