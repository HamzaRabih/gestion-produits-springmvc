package ma.enset.iibdcc.springmvcthymeleafspringsecurity.repositories;

import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
