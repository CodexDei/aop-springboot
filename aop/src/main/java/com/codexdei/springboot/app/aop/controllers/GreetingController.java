package com.codexdei.springboot.app.aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codexdei.springboot.app.aop.services.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
        
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepe", "Hey,Welcome")));
    }

        @GetMapping("/greeting-exception")
    public ResponseEntity<?> greetingException(){
        
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloExcepcion("Pepe", "Hey,Welcome")));
    }

}
