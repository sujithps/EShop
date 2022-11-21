package in.upcode.eshop.controller;

import in.upcode.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    final List<Product> products = List.of(
            new Product(1, "Shoe", 10),
            new Product(2, "Book", 100),
            new Product(3, "Computer", 3)
    );

    @RequestMapping("products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return products;
    }

    @RequestMapping("view/products")
    public String displayProducts(Model model) {
        model.addAttribute("products", products);

        return "products";
    }
}
