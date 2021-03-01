package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.auth.UserAuthService;
import com.rowatk.invoicer.dto.mappers.UserMapper;
import com.rowatk.invoicer.dto.model.UserDTO;
import com.rowatk.invoicer.dto.responses.ApiResponse;
import com.rowatk.invoicer.dto.responses.ApiResponseFactory;
import com.rowatk.invoicer.dto.responses.GeneralResponse;
import com.rowatk.invoicer.exception.AuthException;
import com.rowatk.invoicer.models.company.User;
import com.rowatk.invoicer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(UserDTO user) {
//        UserDTO result = userService.add(user);
        return ApiResponseFactory.ok(userService.add(user));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        Optional<String> token = userAuthService.login(username, password);
        return ApiResponseFactory.ok(
                new GeneralResponse(
                        "token",
                        token.orElseThrow(() -> new AuthException("Invalid username/password provided"))));
    }

    @GetMapping("/current")
    public ResponseEntity<ApiResponse> getCurentUser(@AuthenticationPrincipal final User user) {
        return ApiResponseFactory.ok(userMapper.entityToDTO(user));
    }

    @GetMapping("/logout")
    public ResponseEntity<ApiResponse> logout(@AuthenticationPrincipal final User user) {
        userAuthService.logout(user);
        return ApiResponseFactory.ok(new GeneralResponse("message", "User successfully logged out"));
    }


}
