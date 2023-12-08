package edu.project3.logEntryParsers;

import edu.project3.LogEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogEntryParserLocalFile implements LogEntryParser {

    @Override
    public List<LogEntry> parseLogs(String path, String from, String to) {
        List<LogEntry> logs;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            logs = parseLogs(from, to, reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }
}
