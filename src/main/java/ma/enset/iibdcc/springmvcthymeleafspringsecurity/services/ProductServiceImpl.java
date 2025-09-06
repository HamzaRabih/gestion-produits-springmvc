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

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

}
