package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.dto.UsernamePasswordDto;
import org.dreameeapi.model.UserDetailsModel;
import org.dreameeapi.response.JwtAuthenticationResponse;
import org.dreameeapi.response.MessResponse;
import org.dreameeapi.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/token")
    public MessResponse getToken(@RequestBody UsernamePasswordDto usernamePasswordDto) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(usernamePasswordDto.getUsername(), usernamePasswordDto.getPassword());
            authentication = authenticationManager.authenticate(authentication);
            UserDetailsModel userDetails = (UserDetailsModel) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails.getUsername(), userDetails.getExpired());
            return new JwtAuthenticationResponse(true, "Successfully", token, "Bearer", userDetails.getExpired());
        } catch (Exception e) {
            return new MessResponse(false, e.getMessage());
        }
    }
}
