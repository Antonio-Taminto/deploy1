package com.deploy1.deploy1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class HelloController {


    @Autowired
    private Environment environment;

    @Value("${devName}")
    private String devNameValue;

    @GetMapping("/hifromdev")
    public ResponseEntity<String> hiFromDev(){
        String devName = environment.getProperty("devName");
        return ResponseEntity.ok().body("hi from the developer: " + devName);
    }
    @GetMapping("/hifromdevalue")
    public ResponseEntity<String> hiFromDevValue(){
        return ResponseEntity.ok().body("hi from the developer: " + devNameValue);
    }
}
