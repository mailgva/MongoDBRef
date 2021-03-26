package com.gorbatenko.mongo.repository;

import com.gorbatenko.mongo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
