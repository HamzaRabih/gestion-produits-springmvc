package ma.enset.iibdcc.springmvcthymeleafspringsecurity.repositories;

import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    void deleteById(Integer productId);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    Page<Product> findByNameContains(String keyword, Pageable pageable);

    Product findById(int id);

}
