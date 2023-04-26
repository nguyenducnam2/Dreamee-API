package org.dreameeapi.service;

import javax.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public Object sendEmail(String to, String subject, String text) {
        try {
            String content = "Thanks you for register account!You can verify your email \nLink verify:" + text;
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            mailSender.send(message);
            return text;
        } catch (Throwable a) {

        }
        return text;
    }
}
