package edu.project3.logEntryParsers;

import edu.project3.LogEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

public class LogEntryParserLocalFile implements LogEntryParser {

    @Override
    public List<LogEntry> parseLogs(String path, String from, String to) {
        LocalDate start = Objects.isNull(from) ? LocalDate.MIN : LocalDate.parse(from).minusDays(1);
        LocalDate end = Objects.isNull(to) ? LocalDate.MAX : LocalDate.parse(to).plusDays(1);
        List<LogEntry> logs = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = PATTERN.matcher(line);
                if (matcher.matches()) {
                    LogEntry log = parseLog(matcher);
                    if (log.timestamp().toLocalDate().isAfter(start) && log.timestamp().toLocalDate().isBefore(end)) {
                        logs.add(log);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return logs;
    }
}
