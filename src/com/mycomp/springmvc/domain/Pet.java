package com.mycomp.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {

    private String petName;
    private Integer petId;

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petId=" + petId +
                '}';
    }
}
