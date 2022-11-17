package in.upcode.eshop.controller;

import in.upcode.eshop.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @GetMapping("products")
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1, "Shoe", 10),
                new Product(2, "Book", 100)
        );
    }
}
