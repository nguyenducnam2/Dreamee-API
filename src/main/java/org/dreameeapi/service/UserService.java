package org.dreameeapi.service;

import org.dreameeapi.entity.User;
import org.dreameeapi.registration.RegistrationRequest;
import org.dreameeapi.registration.token.VerificationToken;
import org.dreameeapi.repository.UserRepository;
import org.dreameeapi.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements org.dreameeapi.service.Service<User> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public User register(RegistrationRequest request) throws Exception {
        Optional<User> user = userRepository.findByEmail(request.email());
        if (user.isPresent()) {
            if (user.get().isEnabled())
                throw new Exception("This email exists: " + request.email());
            return user.get();
        }
        User newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setEmail(request.email());
        newUser.setRole(request.role());
        return userRepository.save(newUser);
    }

    public void saveToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        verificationTokenRepository.save(verificationToken);
    }

    public String validateToken(VerificationToken token) {
        if (token == null) {
            return "Eroor null token";
        }
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpiration().getTime() - calendar.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(token);
            return "Token expired";
        }
        verificationTokenRepository.delete(token);
        token.getUser().setEnabled(true);
        userRepository.save(token.getUser());
        return "Sucess verify account!You can login";
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public boolean exists(User user) {
        return userRepository.existsById(user.getId());
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
