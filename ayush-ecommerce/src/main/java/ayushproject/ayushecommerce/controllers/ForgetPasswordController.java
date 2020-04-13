package ayushproject.ayushecommerce.controllers;

import ayushproject.ayushecommerce.dto.PasswordDto;
import ayushproject.ayushecommerce.services.ForgetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ForgetPasswordController {

    @Autowired
    ForgetPassword forgetPassword;

//    @PostMapping(path = "reset-password/{token}")
//    public String resetpassword(@Valid @RequestBody PasswordDto passwordDto, @PathVariable String token){
//        return forgetPassword.resetPassword(passwordDto,token);
//    }
}
