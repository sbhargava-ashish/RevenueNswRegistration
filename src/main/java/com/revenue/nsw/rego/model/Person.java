package com.revenue.nsw.rego.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String age;

}
