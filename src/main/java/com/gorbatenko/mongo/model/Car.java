package com.gorbatenko.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("cars")
public class Car {
    @Id
    private String id;

    private String name;

    private String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
