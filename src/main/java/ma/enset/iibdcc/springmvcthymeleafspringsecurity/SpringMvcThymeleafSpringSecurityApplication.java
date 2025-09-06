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

		products.add(new Product("IPhone 14", 10000, 50));
		products.add(new Product("Samsung S22", 8500, 30));
		products.add(new Product("Xiaomi Mi 11", 4500, 70));
		products.add(new Product("Huawei P50", 6000, 40));
		products.add(new Product("OnePlus 9 Pro", 7000, 25));
		products.add(new Product("Google Pixel 7", 7200, 35));
		products.add(new Product("Sony Xperia 5", 6800, 15));
		products.add(new Product("Oppo Find X5", 6400, 20));
		products.add(new Product("Realme GT", 4800, 60));
		products.add(new Product("Asus ROG Phone 6", 9500, 10));
		products.add(new Product("MacBook Pro 14", 20000, 12));
		products.add(new Product("Dell XPS 13", 15000, 20));
		products.add(new Product("HP Spectre x360", 14000, 18));
		products.add(new Product("Lenovo ThinkPad X1", 16000, 22));
		products.add(new Product("MSI Gaming GF65", 13000, 25));
		products.add(new Product("iPad Pro 12.9", 12000, 30));
		products.add(new Product("Samsung Galaxy Tab S8", 9500, 28));
		products.add(new Product("Apple Watch Series 8", 5000, 50));
		products.add(new Product("Samsung Galaxy Watch 5", 3500, 45));
		products.add(new Product("AirPods Pro 2", 3000, 80));


		Product product = Product.builder()
				.name("PC")
				.price(1000)
				.build();

		 products.add(product);

		productRepository.saveAll(products);

		productRepository.findAll().forEach(System.out::println);
	};
	}


/*

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				/// code
			}
		};
	}
 */



}
