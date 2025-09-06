package ma.enset.iibdcc.springmvcthymeleafspringsecurity.services;

import jakarta.validation.Valid;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();

    void saveProduct(Product product);

    void deleteProductById(int productId);

    public List<Product> searchProducts(String keyword);

    public Product getProductById(int id);
}
