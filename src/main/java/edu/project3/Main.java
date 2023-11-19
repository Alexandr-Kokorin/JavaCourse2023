package edu.project3;

import edu.project3.logEntryParsers.LogEntryParserLocalFile;
import edu.project3.logEntryParsers.LogEntryParserURL;
import java.util.ArrayList;
import java.util.List;

public final class Main {

    private Main() {}

    @SuppressWarnings("InnerAssignment")
    public static void main(String[] args) {
        String path = args[1];
        String from = null;
        String to = null;
        Format format = Format.MARKDOWN;
        for (int i = 2; i < args.length; i += 2) {
            switch (args[i]) {
                case "--from" -> from = args[i + 1];
                case "--to" -> to = args[i + 1];
                case "--format" -> format = Format.valueOf(args[i + 1].toUpperCase());
                default -> {
                    return;
                }
            }
        }
        List<LogEntry> logs = getLogs(path, from, to);
        //...
    }

    private static List<LogEntry> getLogs(String path, String from, String to) {
        List<LogEntry> logs = new ArrayList<>();
        if (path.contains("https://") || path.contains("http://")) {
            var logEntryParser = new LogEntryParserURL();
            logs = logEntryParser.parseLogs(path, from, to);
        } else {
            var logEntryParser = new LogEntryParserLocalFile();
            for (String p: getPaths(path)) {
                List<LogEntry> temp = logEntryParser.parseLogs(p, from, to);
                logs.addAll(temp);
            }
        }
        return logs;
    }

    private static List<String> getPaths(String path) {
        List<String> paths = new ArrayList<>();
        if (path.contains("*")) {
            // Обработка неточного пути к файлам
        } else {
            paths.add(path);
        }
        return paths;
    }
}
