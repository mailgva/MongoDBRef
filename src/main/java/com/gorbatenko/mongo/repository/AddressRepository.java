package com.gorbatenko.mongo.repository;

import com.gorbatenko.mongo.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
