package com.log.ingestor.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.log.ingestor.services.LogService;

@RestController
public class AddLogsController {
    LogService logService = new LogService();

    @PostMapping(path="/add")
    public ResponseEntity<String> addLogs(@RequestBody String logData) {        
        boolean isLogAdded = logService.addLog(logData);
        if(isLogAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Logs added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Unprocessable Logs");
        }
        
    }
}