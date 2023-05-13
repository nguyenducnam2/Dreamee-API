package org.dreameeapi.controller;

import lombok.RequiredArgsConstructor;
import org.dreameeapi.dto.UsernamePasswordDto;
import org.dreameeapi.model.JwtAuthenticationResponseModel;
import org.dreameeapi.model.ResponseModel;
import org.dreameeapi.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/token")
    public ResponseModel getToken(@RequestBody UsernamePasswordDto usernamePasswordDto) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(usernamePasswordDto.getUsername(), usernamePasswordDto.getPassword());
            authentication = authenticationManager.authenticate(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails.getUsername());
            return new JwtAuthenticationResponseModel("Successfully", token, "Bearer",
                    jwtService.extractExpiredDate(token).getTime() - System.currentTimeMillis());
        } catch (Exception e) {
            return new ResponseModel("Invalid Username Password");
        }
    }

    @PostMapping("/extractSubjectToken")
    public ResponseModel extractSubjectToken(@RequestParam String token) throws Exception {
        return new ResponseModel(jwtService.extractSubject(token).toString());
    }

}
