package com.revenue.nsw.rego.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String age;

    public Person() {}

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Vehicle> vehicles = new ArrayList<>();
}
