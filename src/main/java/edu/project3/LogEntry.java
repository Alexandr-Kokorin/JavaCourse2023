package edu.project3;

import java.time.OffsetDateTime;

public record LogEntry(
    String ipAddress,
    OffsetDateTime timestamp,
    String requestLine,
    int statusCode,
    long responseSize,
    String referrer,
    String userAgent
) {}
