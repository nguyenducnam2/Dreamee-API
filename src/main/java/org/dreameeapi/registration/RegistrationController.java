package org.dreameeapi.registration;

import jakarta.servlet.http.HttpServletRequest;
import org.dreameeapi.entity.User;
import org.dreameeapi.registration.event.RegistrationCompleteEvent;
import org.dreameeapi.registration.token.VerificationToken;
import org.dreameeapi.repository.VerificationTokenRepository;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private VerificationTokenRepository tokenRepository;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request, HttpServletRequest servletRequest) throws Exception {
        // save data to db okay,but enable = false
        User user = userService.register(request);
        // email send , wait user check email
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationURL(servletRequest)));
        return "Successfully! Please Check You Email To Verify Account";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam("token") String token) {
        Optional<VerificationToken> verificationToken = tokenRepository.findByToken(token);
        if (verificationToken.isEmpty()) {
            return "This Token does not exists";
        }
        if (verificationToken.get().getUser().isEnabled()) {
            return "Your account has been already verify";
        }
        return userService.validateToken(verificationToken.get());
    }

    public String applicationURL(HttpServletRequest servletRequest) {
        return "https://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + "/api/registration";
    }
}
