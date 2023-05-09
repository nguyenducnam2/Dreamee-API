package org.dreameeapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.dreameeapi.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private SendMailService mailService;

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestParam String email,
                           @RequestParam String subject,
                           @RequestParam String text, HttpServletRequest request) {
        if (mailService.sendSimpleMail(email, subject, text))
            request.setAttribute("mess", "Successfully!Please check email: " + email);
        else
            request.setAttribute("error", "Failed to sent email to email: " + email);
        return "home/index";
    }
}
