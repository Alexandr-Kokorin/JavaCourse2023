package edu.project3.logEntryParsers;

import edu.project3.LogEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class LogEntryParserURL implements LogEntryParser {

    @Override
    public List<LogEntry> parseLogs(String url, String from, String to) {
        List<LogEntry> logs;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader((new URL(url))
            .openConnection().getInputStream()))) {
            logs = parseLogs(from, to, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }
}
