package ayushproject.ayushecommerce.services;

import ayushproject.ayushecommerce.dto.PasswordDto;
//import ayushproject.ayushecommerce.entities.ConfirmationToken;
import ayushproject.ayushecommerce.entities.User;
import ayushproject.ayushecommerce.entities.VerificationToken;
import ayushproject.ayushecommerce.exceptions.ConfirmPasswordException;
import ayushproject.ayushecommerce.repo.ConfirmationTokenRepo;
import ayushproject.ayushecommerce.repo.UserRepo;
import ayushproject.ayushecommerce.repo.VerificationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ForgetPassword<token> {

    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailService emailService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    VerificationTokenRepo verificationTokenRepo;

    public String forgotPassword(String email) {
        System.out.println(email + ">>>>>>>>>>");
        User user = userRepo.findByname(email);
        System.out.println(user.getEmail());
        if (user.getEmail() == null) {
            throw new UsernameNotFoundException("User Not Found");
        } else {
            String token = UUID.randomUUID().toString();
//            ConfirmationToken confirmationToken = new ConfirmationToken();
//            confirmationToken.(user.getEmail());
//            confirmationToken.setConfirmationToken(new Date());
//            confirmationToken.getTokenId(token);
            VerificationToken verificationToken=new VerificationToken();
            verificationToken.setUserEmail(user.getEmail());
            verificationToken.setGeneratedDate(new Date());
            verificationToken.setToken(token);
            emailService.sendEmail("RESET YOUR PASSWORD", "Use This Link"
                    + "http://localhost:8080/reset-password" + token, email);
            verificationTokenRepo.save(verificationToken);
        }
        return "Kindly Check Your Email";
    }

//    public String resetPassword(PasswordDto passwordDto, String token) {
//        ConfirmationToken verificationToken = ConfirmationTokenRepo.getByToken(token);
//       // User user = new User();
//        String password = passwordDto.getPassword();
//        String confirmPassword = passwordDto.getConfirmpassword();
//        if (verificationToken.getUser() == null)
//            return "http://localhost:8080/reset-password/" + token + "has been expired";
//        else {
//            if (!password.equals(confirmPassword)) {
//                throw new ConfirmPasswordException("NOT A MATCH");
//            } else {
//                User user = new User();
//                User user1 = userRepo.findByname(email);
//                if (user1.getEmail() == null)
//                    return ("user not exist");
//                else {
//                    try {
//                        emailService.sendEmail("ACCOUNT SECURITY ISSUE", "Hii, \nYour password has been changed.", user.getEmail());
//                        String encodedPassword = passwordEncoder.encode(password);
//                        userRepo.updatePassword(encodedPassword, user1.getEmail());
//                        confirmationTokenRepo.deleteById(verificationToken.getTokenId(token));
//                    } catch (Exception ex) {
//                        return "Hit  User name the reset password link again.";
//                    }
//                }
//            }
//            return "password has changed successfully";
//
//        }
//    }
}
