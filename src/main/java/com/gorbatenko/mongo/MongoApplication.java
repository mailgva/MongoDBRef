package com.gorbatenko.mongo;

import com.gorbatenko.mongo.model.Address;
import com.gorbatenko.mongo.model.Car;
import com.gorbatenko.mongo.model.User;
import com.gorbatenko.mongo.repository.AddressRepository;
import com.gorbatenko.mongo.repository.CarRepository;
import com.gorbatenko.mongo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.Repository;

import java.util.List;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MongoApplication.class, args);

		CarRepository carRepository = ctx.getBean(CarRepository.class);
		AddressRepository addressRepository = ctx.getBean(AddressRepository.class);
		UserRepository userRepository = ctx.getBean(UserRepository.class);

		addressRepository.deleteAll();;
		carRepository.deleteAll();
		userRepository.deleteAll();


		List<Car> cars = List.of(
				new Car("BMW", "Blue"),
				new Car("Ford", "Black"),
				new Car("Toyota", "Red"),
				new Car("VW", "Green"),
				new Car("Honda", "White")

		);

		carRepository.saveAll(cars);

		Address address = new Address("Odessa", "Pushkinskaya 23");
		addressRepository.save(address);

		User user = new User("Vladimir", 40, address, cars);

		userRepository.save(user);

		user = userRepository.findAll().get(0);

		System.out.println(user);
		user.getCars().forEach(System.out::println);


	}

}
