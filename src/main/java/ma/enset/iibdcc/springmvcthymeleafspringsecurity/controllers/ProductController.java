package ma.enset.iibdcc.springmvcthymeleafspringsecurity.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites.Product;

import ma.enset.iibdcc.springmvcthymeleafspringsecurity.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



/**
 * @Controller ne prend pas de chemin en paramètre.
 * C’est @RequestMapping (ou @RestController) qui permet de définir la base du chemin.
 **/
@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String index(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
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

}
