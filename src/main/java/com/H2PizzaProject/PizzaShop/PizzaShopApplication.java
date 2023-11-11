package com.H2PizzaProject.PizzaShop;

import com.H2PizzaProject.PizzaShop.model.Employee;
import com.H2PizzaProject.PizzaShop.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.H2PizzaProject.PizzaShop")
public class PizzaShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzaShopApplication.class, args);
	}
    @Bean
	CommandLineRunner commandLineRunner(EmployeeRepository repository){
		return args -> {
			repository.save(new Employee(null,"admin","true","admin"));
		};
	}

}
