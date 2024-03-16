package com.log.ingestor.logingestor.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.time.Instant;

import com.log.ingestor.logingestor.services.LogService;
import com.log.ingestor.logingestor.utils.Log;

@RestController
public class GetLogsController {
    LogService logService = new LogService();

    @GetMapping(path = "/find")
    public List<Log> findLogs(
            @RequestParam(required = false) String traceId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String resourceId) {
        
        return logService.findLogs(traceId, from, to, level, resourceId);
    }
}