package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.services.MailService;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping(value = "/sendemailnotification/{email}/{scheduleid}")
    public Boolean sendMail(@PathVariable String email,@PathVariable Integer scheduleid){
        try {
            return mailService.sendEmailNotification(email,scheduleid);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
