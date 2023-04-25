package org.dreameeapi.registration;

import jakarta.servlet.http.HttpServletRequest;
import org.dreameeapi.entity.User;
import org.dreameeapi.registration.event.RegistrationCompleteEvent;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request, HttpServletRequest servletRequest) throws Exception {
        // save data to db okay,but enable = false
        User user = userService.register(request);
        // email send , wait user check email
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationURL(servletRequest)));
        return "Successfully! Please Check You Email To Verify Account";
    }

    public String applicationURL(HttpServletRequest servletRequest) {
        return "http://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + servletRequest.getContextPath();
    }
}
