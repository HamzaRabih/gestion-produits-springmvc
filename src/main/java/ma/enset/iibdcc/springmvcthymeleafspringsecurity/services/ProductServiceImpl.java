package ma.enset.iibdcc.springmvcthymeleafspringsecurity.services;

import lombok.AllArgsConstructor;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
