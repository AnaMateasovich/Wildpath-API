package com.example.wildpath.auth;

import com.example.wildpath.config.JwtService;
import com.example.wildpath.entity.Role;
import com.example.wildpath.entity.User;
import com.example.wildpath.entity.VerificationToken;
import com.example.wildpath.repository.IUserRepository;
import com.example.wildpath.repository.IVerificationTokenRepository;
import com.example.wildpath.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Value("${frontend.url}")
    private String frontendUrl;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final IVerificationTokenRepository tokenRepository;
    private final EmailService emailService;

    public String register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("This email is already associated with an account.");
        }

        var user = User.builder()
                .name(request.getName())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .enabled(false)
                .build();

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, user, LocalDateTime.now().plusHours(24));
        tokenRepository.save(verificationToken);

        String link = frontendUrl + "/verify-account?token=" + token;
        emailService.sendVerificationEmail(user.getEmail(), link);

        return "We have sent you a confirmation email. Please check your inbox to active your account";
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        try {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        } catch (DisabledException ex) {
            throw new RuntimeException("Your account is not yet activated. Please check your email.");
        }


        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }



}
