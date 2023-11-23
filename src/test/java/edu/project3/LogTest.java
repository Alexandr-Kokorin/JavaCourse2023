package edu.project3;

import edu.project3.logEntryParsers.LogEntryParser;
import edu.project3.logEntryParsers.LogEntryParserLocalFile;
import edu.project3.logEntryParsers.LogEntryParserURL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogTest {

    private final static DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss XX", Locale.ENGLISH);

    static Arguments[] logs() {
        return new Arguments[] {
            Arguments.of(
                new LogEntryParserLocalFile(),
                "logs" + File.separator + "2015-05-24.txt",
                null,
                null,
                new LogEntry(
                    "194.58.90.185",
                    OffsetDateTime.parse("24/May/2015:00:05:21 +0000", FORMATTER),
                    "GET /downloads/product_1 HTTP/1.1",
                    Integer.parseInt("304"),
                    Long.parseLong("0"),
                    "-",
                    "Debian APT-HTTP/1.3 (0.9.7.8)"
                )
            ),
            Arguments.of(
                new LogEntryParserURL(),
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                null,
                null,
                new LogEntry(
                    "93.180.71.3",
                    OffsetDateTime.parse("17/May/2015:08:05:32 +0000", FORMATTER),
                    "GET /downloads/product_1 HTTP/1.1",
                    Integer.parseInt("304"),
                    Long.parseLong("0"),
                    "-",
                    "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)"
                )
            ),
            Arguments.of(
                new LogEntryParserURL(),
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                "2015-05-24",
                null,
                new LogEntry(
                    "194.58.90.185",
                    OffsetDateTime.parse("24/May/2015:00:05:21 +0000", FORMATTER),
                    "GET /downloads/product_1 HTTP/1.1",
                    Integer.parseInt("304"),
                    Long.parseLong("0"),
                    "-",
                    "Debian APT-HTTP/1.3 (0.9.7.8)"
                )
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("logs")
    void logEntryParserTest(LogEntryParser parser, String path, String start, String end, LogEntry excepted) {
        var result = parser.parseLogs(path, start, end);

        assertThat(result.get(0)).isEqualTo(excepted);
    }

    @Test
    void logsFromMultipleFilesTest() {
        var result = Main.getLogs("logs" + File.separator + "2015*", null, null);
        LogEntry log = new LogEntry(
            "74.63.142.188",
            OffsetDateTime.parse("25/May/2015:23:05:45 +0000", FORMATTER),
            "GET /downloads/product_1 HTTP/1.1",
            Integer.parseInt("304"),
            Long.parseLong("0"),
            "-",
            "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.14)"
        );

        assertThat(result.get(result.size() - 1)).isEqualTo(log);
    }
}
