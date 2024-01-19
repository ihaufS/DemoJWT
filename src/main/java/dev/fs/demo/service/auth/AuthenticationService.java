package dev.fs.demo.service.auth;

import dev.fs.demo.dto.LoginDTO;
import dev.fs.demo.dto.RegisterDTO;
import dev.fs.demo.model.Token;
import dev.fs.demo.model.User;
import dev.fs.demo.repository.UserRepository;
import dev.fs.demo.service.JwtService;
import dev.fs.demo.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Token register(RegisterDTO request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return Token.builder()
                .token(jwtToken)
                .build();
    }

    public Token login(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return Token.builder()
                .token(jwtToken)
                .build();
    }
}
