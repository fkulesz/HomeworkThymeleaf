package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping()
    String home(Model model) {
        model.addAttribute("product" , new Product());
        return "newProduct";
    }

    @PostMapping("/add")
    String addProduct(Product product) {
        productRepository.add(product);
        return "success";
    }

    @GetMapping("/lista")
    String getProductsList(Model model){
        List<Product> products = productRepository.findAll();
        double sum = productRepository.countPrice();
        model.addAttribute("products", products);
        model.addAttribute("sum", sum);

        return "productList";
    }
    @GetMapping("/tabela")
    String getProductsTable(Model model){
        List<Product> products = productRepository.findAll();
        double sum = productRepository.countPrice();
        model.addAttribute("products", products);
        model.addAttribute("sum", sum);

        return "productTable";
    }

}
