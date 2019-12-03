package com.github.filipve1994.msuserservice.web;

import com.github.filipve1994.msuserservice.models.User;
import com.github.filipve1994.msuserservice.services.UserService;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/members")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody User input) {
        return ResponseEntity.ok(userService.registerUser(input));
    }
}
