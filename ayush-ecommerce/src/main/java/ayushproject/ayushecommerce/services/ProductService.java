package ayushproject.ayushecommerce.services;

import ayushproject.ayushecommerce.entities.Product;
import ayushproject.ayushecommerce.entities.User;
import ayushproject.ayushecommerce.repo.ProductRepo;
import ayushproject.ayushecommerce.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    public Iterable<Product> allProducts(){return productRepo.findAll();}


    public List<Product> perCategory(String category){return productRepo.perCategory(category);}
    public List<User> allUsers(){return userRepo.allUsers();}

    public String addProduct(Product product){
        productRepo.save(product);
        return "Product Added..";
    }

    public String editProduct(Product product){
        productRepo.save(product);
        return "Product Updated";
    }

    public String removeProduct(Integer productId){
        productRepo.delete(productRepo.findById(productId).get());
        return "Product deleted";
    }
}
