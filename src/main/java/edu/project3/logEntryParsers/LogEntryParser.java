package edu.project3.logEntryParsers;

import edu.project3.LogEntry;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LogEntryParser {

    String LOG_ENTRY_PATTERN =
        "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
    Pattern PATTERN = Pattern.compile(LOG_ENTRY_PATTERN);
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss XX", Locale.ENGLISH);

    List<LogEntry> parseLogs(String path, String from, String to);

    default List<LogEntry> parseLogs(String from, String to, BufferedReader reader) {
        LocalDate start = Objects.isNull(from) ? LocalDate.MIN : LocalDate.parse(from).minusDays(1);
        LocalDate end = Objects.isNull(to) ? LocalDate.MAX : LocalDate.parse(to).plusDays(1);
        List<LogEntry> logs = new ArrayList<>();

        try {
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

    @SuppressWarnings("MagicNumber")
    default LogEntry parseLog(Matcher log) {
        return new LogEntry(
            log.group(1),
            log.group(3),
            OffsetDateTime.parse(log.group(4), FORMATTER),
            log.group(5),
            Integer.parseInt(log.group(6)),
            Long.parseLong(log.group(7)),
            log.group(8),
            log.group(9)
        );
    }
}
