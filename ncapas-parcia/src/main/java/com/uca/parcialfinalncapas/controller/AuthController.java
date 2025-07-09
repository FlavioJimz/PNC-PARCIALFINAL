package com.uca.parcialfinalncapas.controller;

import com.uca.parcialfinalncapas.dto.request.LoginRequest;
import com.uca.parcialfinalncapas.dto.request.UserCreateRequest;
import com.uca.parcialfinalncapas.dto.response.GeneralResponse;
import com.uca.parcialfinalncapas.dto.response.JwtResponse;
import com.uca.parcialfinalncapas.dto.response.UserResponse;
import com.uca.parcialfinalncapas.security.JwtUtil;
import com.uca.parcialfinalncapas.service.UserService;
import com.uca.parcialfinalncapas.utils.ResponseBuilderUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            String jwt = jwtUtil.generateJwtToken(authentication);
            JwtResponse jwtResponse = new JwtResponse(jwt);

            return ResponseBuilderUtil.buildResponse("Login exitoso", HttpStatus.OK, jwtResponse);

        } catch (BadCredentialsException e) {
            return ResponseBuilderUtil.buildResponse("Usuario o contraseña incorrectos", HttpStatus.UNAUTHORIZED, null);
        } catch (Exception e) {
            e.printStackTrace(); // imprime el error en consola
            return ResponseBuilderUtil.buildResponse("Error al autenticar", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@Valid @RequestBody UserCreateRequest userRequest) {
        UserResponse userResponse = userService.save(userRequest);
        return ResponseBuilderUtil.buildResponse("Usuario registrado correctamente", HttpStatus.CREATED, userResponse);
    }
}
