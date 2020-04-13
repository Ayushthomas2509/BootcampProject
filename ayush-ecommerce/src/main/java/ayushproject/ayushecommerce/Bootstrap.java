package ayushproject.ayushecommerce;

import ayushproject.ayushecommerce.entities.*;
import ayushproject.ayushecommerce.entities.category.Electronics;
import ayushproject.ayushecommerce.entities.category.Fashion;
import ayushproject.ayushecommerce.enums.IN_STOCK;
import ayushproject.ayushecommerce.repo.ProductRepo;
import ayushproject.ayushecommerce.repo.RoleRepo;
import ayushproject.ayushecommerce.repo.UserRepo;
import ayushproject.ayushecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserService userService;
    @Autowired
    RoleRepo roleRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

        Role admin = new Role(1,"ROLE_ADMIN");
        Role seller = new Role(2,"ROLE_SELLER");
        Role customer = new Role(3,"ROLE_CUSTOMER");
        roleRepo.save(admin);
        roleRepo.save(customer);
        roleRepo.save(seller);

        Admin admin1 = new Admin();
        admin1.setFirstName("Ayush");
        admin1.setLastName("Thomas");
        admin1.setAge(24);
        admin1.setAdminid(301);
        admin1.setGender("M");
        admin1.setPassword(passwordEncoder.encode("Ayush@"));
        admin1.setName("ayushthomas09");
        admin1.setEmail("ayushthomas09@outlook.com");
        Address address = new Address();
        address.setArea("Rohini");
        address.setHousenumber("Flat 103 D Block");
        address.setCity("New Delhi");
        address.setState("Delhi");
        address.setCountry("India");
        address.setPincode("110085");
        userRepo.save(admin1);

        Customer user1 =new Customer();
        user1.setFirstName("Kartik");
        user1.setLastName("Kumar");
        user1.setName("KartikKumar25");
        user1.setEmail("kar@gmail.com");
        user1.setPassword(passwordEncoder.encode("Kartik@"));
        user1.setAddress(Arrays.asList(address));
        user1.setAge(21);
        user1.setGender("M");
        userRepo.save(user1);

        Seller seller1 = new Seller();
        seller1.setFirstName("Abhi");
        seller1.setLastName("Thomas");
        seller1.setPassword(passwordEncoder.encode("Abhi@"));
        seller1.setAge(23);
        seller1.setEmail("FashionInn@gmail.com");
        seller1.setName("FasionInn");
        seller1.setAddress(address);
        seller1.setGST_No(123456);
        seller1.setGender("M");
        userRepo.save(seller1);

        Electronics phone = new Electronics();
        phone.setBrand("Apple");
        phone.setProcessor("A13 Bionic");
        phone.setDisplay("5.1 Inch OLED");
        phone.setName("Iphone 11 Pro Max");
        phone.setDescription("Class Efficinet");
        phone.setInStock(IN_STOCK.Yes);
        phone.setQuantity(10);
        phone.setStorage("256 gb");
        phone.setWarranty("1 Year");
        phone.setType("Cellular Phone");
        productRepo.save(phone);

        Fashion shirt = new Fashion();
        shirt.setBrand("UCB");
        shirt.setColor("Red");
        shirt.setSize("L");
        shirt.setFit("Regular");
        shirt.setMaterial("Cotton 100%");
        shirt.setQuantity(15);
        shirt.setInStock(IN_STOCK.Yes);
        shirt.setName("Shirt UCB");
        shirt.setSeller(seller1);
        productRepo.save(shirt);



    }
}
