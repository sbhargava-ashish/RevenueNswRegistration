package com.revenue.nsw.rego.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regoNumber;

    private String brand;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
}
