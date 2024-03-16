package com.log.ingestor.logingestor.services;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.log.ingestor.logingestor.utils.Log;

@Service
public class LogService {

    // Dummy log data
    private static List<Log> dummyLogs = new ArrayList<>();

    // Constructor to initialize dummy log data
    public LogService() {
        // Populate dummy logs
        dummyLogs.add(new Log("1", Instant.parse("2022-01-01T10:00:00Z"), "error", "trace-1", "resource-1"));
        dummyLogs.add(new Log("2", Instant.parse("2022-01-02T10:00:00Z"), "info", "trace-2", "resource-2"));
        dummyLogs.add(new Log("3", Instant.parse("2022-01-03T10:00:00Z"), "warn", "trace-3", "resource-3"));
    }

    // Method to find logs based on parameters
    public List<Log> findLogs(String traceId, Instant from, Instant to, String level, String resourceId) {
        List<Log> filteredLogs = new ArrayList<>();
        for (Log log : dummyLogs) {
            // Apply filters
            if ((traceId == null || log.getTraceId().equals(traceId)) &&
                (from == null || log.getTimestamp().compareTo(from) >= 0) &&
                (to == null || log.getTimestamp().compareTo(to) <= 0) &&
                (level == null || log.getLevel().equals(level)) &&
                (resourceId == null || log.getResourceId().equals(resourceId))) {
                filteredLogs.add(log);
            }
        }
        return filteredLogs;
    }

    public boolean addLog(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            Log log = objectMapper.readValue(jsonString, Log.class);
            dummyLogs.add(log);
            
            return true;
        } catch (JsonProcessingException e) {
            System.out.println("Error: An error ocurred while parsing logs. "+e.getMessage());
        }
        return false;
    }
}
