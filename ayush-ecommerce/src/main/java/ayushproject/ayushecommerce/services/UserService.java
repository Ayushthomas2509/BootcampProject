package ayushproject.ayushecommerce.services;

import ayushproject.ayushecommerce.entities.ApplicationUser;
import ayushproject.ayushecommerce.entities.Cart;
import ayushproject.ayushecommerce.entities.Product;
import ayushproject.ayushecommerce.entities.User;
import ayushproject.ayushecommerce.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserService {
    List<Product> productList = new LinkedList<>();
    List<Cart> cartList = new LinkedList<>();
    List<Integer> quantitylist = new LinkedList<>();
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    SellerRepo sellerRepo;

    public Iterable<User> allUsers(){return userRepo.findAll();}

    public User findUser(String name){return userRepo.findByname(name);}

    public String addUser(User user){
        userRepo.save(user);
        return "User added";

    }

    public String deleteUser(String name) {
        userRepo.delete(userRepo.findByname(name));
        return "User Deleted";
    }

    public String editUser(User user) {
        userRepo.save(user);
        return "User Updated";
    }

    public ApplicationUser loadUsername(String name){
        User user =userRepo.findByname(name);
        System.out.println(user);
        if (name!=null){
            return new ApplicationUser(user.getName(),user.getPassword(),user.getRoles());
        }
        else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }
}
