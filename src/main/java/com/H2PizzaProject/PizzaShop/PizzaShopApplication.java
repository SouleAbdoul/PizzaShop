package com.H2PizzaProject.PizzaShop;

import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.model.Product;
import com.H2PizzaProject.PizzaShop.repository.EmployeeRepository;
import com.H2PizzaProject.PizzaShop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;


@SpringBootApplication
@ComponentScan("com.H2PizzaProject.PizzaShop")
public class PizzaShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzaShopApplication.class, args);
	}
	// This code below create the first employee as you run the application
	// but that do not need to be there as all the endpoints are working properly
	// therefore can be commented if needed the first employee would need to be created through postman.
    @Bean
	CommandLineRunner commandLineRunner(EmployeeRepository repository, ProductRepository productRepository){
		return args -> {
			repository.save(new Employee(null,"admin","true","admin"));
			productRepository.save(new Product(1,"Soda", 3.25, "2 Liter bottle"));
			productRepository.save(new Product(2,"Pizza - small Pepperoni", 7.35, "8 inch"));
			productRepository.save(new Product(3,"Pizza - medium Pepperoni", 9.35, "12 inch"));
			productRepository.save(new Product(4,"Pizza - large Pepperoni", 14.00, "18 inch"));
			productRepository.save(new Product(5,"Pizza - medium house special", 10.50, "12 inch"));
			productRepository.save(new Product(6,"Pizza - small house special", 8.50, "8 inch"));
			productRepository.save(new Product(7,"Pizza - large house special", 16.00, "18 inch"));
		};

	}

}
