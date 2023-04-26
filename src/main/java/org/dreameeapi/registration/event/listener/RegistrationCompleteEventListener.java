package org.dreameeapi.registration.event.listener;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dreameeapi.entity.User;
import org.dreameeapi.registration.event.RegistrationCompleteEvent;
import org.dreameeapi.service.EmailService;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // get user
        User user = event.getUser();
        // create verifycation token
        String verificationToken = UUID.randomUUID().toString();
        // save to db
        userService.saveToken(user, verificationToken);
        // build verification url
        String url = event.getApplicationURL() + "/verify?token=" + verificationToken;
        // send the email
        log.info("Click the link to verify email ! Thanks you\n" + emailService.sendEmail(user.getEmail(), "Verify Email", url));
    }


}
