package com.log.ingestor.logingestor.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public class Log {
    private String id;
    private Instant timestamp;
    private String level;
    private String traceId;
    private String resourceId;

    // Constructor
    public Log() {
    }

    public Log(@JsonProperty("id") String id,
               @JsonProperty("timestamp") Instant timestamp,
               @JsonProperty("level") String level,
               @JsonProperty("traceId") String traceId,
               @JsonProperty("resourceId") String resourceId) {
        this.id = id;
        this.timestamp = timestamp;
        this.level = level;
        this.traceId = traceId;
        this.resourceId = resourceId;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
