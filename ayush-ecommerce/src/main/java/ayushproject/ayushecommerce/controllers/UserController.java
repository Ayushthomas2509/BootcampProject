package ayushproject.ayushecommerce.controllers;

import ayushproject.ayushecommerce.entities.User;
import ayushproject.ayushecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> allUsers(){
         return userService.allUsers();
    }

    @GetMapping("users/{name}")
    public User findUser(@PathVariable String name){
         return userService.findUser(name);
    }

    @GetMapping("users/edit")
    public String editUser(@RequestBody User user){
        return userService.editUser(user);
    }
}
