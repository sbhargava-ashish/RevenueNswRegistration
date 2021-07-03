package com.revenue.nsw.rego.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String age;

    @OneToMany(
            mappedBy = "person"
    )
    private List<Vehicle> vehicles = new ArrayList<>();
}
