package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.ApiResponse;
import tk.giaiphapchannuoi.server.model.JwtAuthenticationResponse;
import tk.giaiphapchannuoi.server.model.LoginRequest;
import tk.giaiphapchannuoi.server.repository.UsersRepository;
import tk.giaiphapchannuoi.server.security.JwtTokenProvider;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping(value = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @GetMapping(value = "/check_login")
    public ResponseEntity<?> checkLogin() {
        ApiResponse apiResponse = new ApiResponse(true,"success");
        return ResponseEntity.ok(apiResponse);
    }

}
