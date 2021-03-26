package com.gorbatenko.mongo.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("users")
@ToString(exclude = "cars")
public class User {
    @Id
    private String id;

    private String name;

    private int age;

    @DBRef
    /* Document will contain only DBRefs with Car.id on collection "cars". Like next:
    * {
        "_id" : ObjectId("605e52a8ffb7131e463bef23"),
        "name" : "Vladimir",
        "age" : 40,
        "cars" : [
                DBRef("cars", ObjectId("605e52a8ffb7131e463bef1e")),
                DBRef("cars", ObjectId("605e52a8ffb7131e463bef1f")),
                DBRef("cars", ObjectId("605e52a8ffb7131e463bef20")),
                DBRef("cars", ObjectId("605e52a8ffb7131e463bef21")),
                DBRef("cars", ObjectId("605e52a8ffb7131e463bef22"))
        ],
        "_class" : "com.gorbatenko.mongo.model.User"
        }
    * */
    List<Car> cars;

    public User(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }
}
