package ayushproject.ayushecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendEmail(String subject, String text, String SentTo){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom("ayushthomas09@gmail.com");
        simpleMailMessage.setTo(SentTo);

        javaMailSender.send(simpleMailMessage);
    }
}