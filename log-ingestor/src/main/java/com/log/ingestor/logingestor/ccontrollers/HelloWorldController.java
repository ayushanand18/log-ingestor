package com.log.ingestor.logingestor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public ResponseEntity<?> helloWorld() {
        Map<String, String> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("message", "everything worked well");

        // Return ResponseEntity with data and HTTP status code
        return ResponseEntity.ok(responseData);
    }

}