package edu.project3.logEntryParsers;

import edu.project3.LogEntry;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface LogEntryParser {

    String LOG_ENTRY_PATTERN =
        "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
    Pattern PATTERN = Pattern.compile(LOG_ENTRY_PATTERN);

    List<LogEntry> parseLogs(String path, String from, String to);

    @SuppressWarnings("MagicNumber")
    default LogEntry parseLog(Matcher log) {
        // 17/May/2015:08:05:32 +0000
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss XX", Locale.ENGLISH);

        return new LogEntry(
            log.group(1),
            OffsetDateTime.parse(log.group(4), formatter),
            log.group(5),
            Integer.parseInt(log.group(6)),
            Long.parseLong(log.group(7)),
            log.group(8),
            log.group(9)
        );
    }
}
