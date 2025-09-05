package ma.enset.iibdcc.springmvcthymeleafspringsecurity;

import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })//Désactiver la protection par défaut de spring security
public class SpringMvcThymeleafSpringSecurityApplication {


	private static ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcThymeleafSpringSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(ProductRepository productRepository) {
	return args1 -> {
		List<Product> products = new ArrayList<>();

		products.add(new Product( "IPhone",1000,100));
		products.add(new Product( "Samsung S22",7000,100));
		products.add(new Product( "Xiaomi mi10",6500,100));

		Product product = Product.builder()
				.name("PC")
				.price(1000)
				.build();

		 products.add(product);

		productRepository.saveAll(products);

		productRepository.findAll().forEach(System.out::println);
	};
	}



	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				/// code
			}
		};
	}



}
