package ayushproject.ayushecommerce.controllers;

import ayushproject.ayushecommerce.entities.Product;
import ayushproject.ayushecommerce.entities.category.Electronics;
import ayushproject.ayushecommerce.entities.category.Fashion;
import ayushproject.ayushecommerce.services.ProductService;
import ayushproject.ayushecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/products")
    public Iterable<Product> allProducts(){
        return productService.allProducts();
    }

    @GetMapping("/products/{category}")
    public List<Product> perCategory(@PathVariable String category){
        return productService.perCategory(category);
    }

    @PostMapping("/add-products/fashion")
    public String addProduct(@RequestBody Fashion fashion) {
        //userService.ensureSeller();
        return productService.addProduct(fashion);
    }

    @PostMapping("/add-products/electronics")
    public String addProduct(@RequestBody Electronics electronics){
        //userService.ensureSeller();
        return productService.addProduct(electronics);
    }

    @PostMapping("/edit-products/fashion")
    public String editProduct(@RequestBody Fashion fashion){
        return productService.editProduct(fashion);
    }

    @PostMapping("/edit-products/electronics")
    public String editProduct(@RequestBody Electronics electronics){
        return productService.editProduct(electronics);
    }

    @PostMapping("/remove-products/{productId}")
    public String removeProduct(@PathVariable Integer productId) {
        return productService.removeProduct(productId);
    }



}
