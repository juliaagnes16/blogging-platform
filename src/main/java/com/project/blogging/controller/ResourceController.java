package com.project.blogging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/secret_resource")
    public ResponseEntity<String> secret() {
        return new ResponseEntity<>("Secret Area", HttpStatus.OK);
    }

    @GetMapping("/public_resource")
    public ResponseEntity<String> noSecret() {
        return new ResponseEntity<>("Public Area", HttpStatus.OK);
    }
}
