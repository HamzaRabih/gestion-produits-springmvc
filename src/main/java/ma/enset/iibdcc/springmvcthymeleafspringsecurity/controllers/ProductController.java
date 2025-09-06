package ma.enset.iibdcc.springmvcthymeleafspringsecurity.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;

import ma.enset.iibdcc.springmvcthymeleafspringsecurity.repositories.ProductRepository;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * @Controller ne prend pas de chemin en paramètre.
 * C’est @RequestMapping (ou @RestController) qui permet de définir la base du chemin.
 **/
@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    /*
    @GetMapping("/products")
    public String index(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "index.html";
    }
        @GetMapping("/products")
    public String listProducts(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size,
                               @RequestParam(name = "keyword", required = false) String keyword) {
        List<Product> products = (keyword != null && !keyword.isEmpty())
                ? productService.searchProducts(keyword)
                : productService.findAllProducts();

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "index.html";
    }
 */
    @GetMapping("/products")
    public String listProducts(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size,
                               @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Product> pageProducts = productRepository.findByNameContains(keyword, PageRequest.of(page, size));

        model.addAttribute("products", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "index.html";
    }



    // Formulaire d’ajout
    @GetMapping("/newProduct")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form.html";
    }

    // Traitement du formulaire
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "product-form.html"; // retourner au formulaire si erreurs
        }
        productService.saveProduct(product);
        return "redirect:/products"; // rediriger vers la liste
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct( @PathVariable("productId") int productId) {
        productService.deleteProductById(productId);
        return "redirect:/products";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") @Valid Product product,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "editProduct";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

}
