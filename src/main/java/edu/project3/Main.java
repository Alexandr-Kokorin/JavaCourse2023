package edu.project3;

import edu.project3.logEntryParsers.LogEntryParser;
import edu.project3.logEntryParsers.LogEntryParserLocalFile;
import edu.project3.logEntryParsers.LogEntryParserURL;
import edu.project3.renderer.Renderer;
import edu.project3.renderer.RendererAdoc;
import edu.project3.renderer.RendererMarkdown;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class Main {

    private Main() {
    }

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
        DataCalculator dataCalculator = new DataCalculator();
        Renderer renderer = format == Format.MARKDOWN ? new RendererMarkdown() : new RendererAdoc();
        print(renderer, dataCalculator, logs, path);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void print(Renderer renderer, DataCalculator dataCalculator, List<LogEntry> logs, String path) {
        String statistic1 = renderer.renderGeneralInformation(
            dataCalculator.getFiles(getPaths(path)),
            dataCalculator.getStartDate(logs),
            dataCalculator.getEndDate(logs),
            dataCalculator.getCountLogs(logs),
            dataCalculator.getAverageTime(logs)
        );
        String statistic2 = renderer.renderRequestedResources(dataCalculator.getResources(logs));
        String statistic3 = renderer.renderResponseCodes(dataCalculator.getCodes(logs));
        String statistic4 = renderer.renderResponseIPAddresses(dataCalculator.getIPAddresses(logs));
        String statistic5 = renderer.renderResponseRequests(dataCalculator.getRequests(logs));
        System.out.println(statistic1);
        System.out.println(statistic2);
        System.out.println(statistic3);
        System.out.println(statistic4);
        System.out.println(statistic5);
    }

    public static List<LogEntry> getLogs(String path, String from, String to) {
        List<LogEntry> logs = new ArrayList<>();
        if (path.contains("https://") || path.contains("http://")) {
            LogEntryParser logEntryParser = new LogEntryParserURL();
            logs = logEntryParser.parseLogs(path, from, to);
        } else {
            LogEntryParser logEntryParser = new LogEntryParserLocalFile();
            for (String p : getPaths(path)) {
                List<LogEntry> temp = logEntryParser.parseLogs(p, from, to);
                logs.addAll(temp);
            }
        }
        return logs;
    }

    public static List<String> getPaths(String path) {
        List<String> paths = new ArrayList<>();
        if (path.contains("*")) {
            int index = path.indexOf('*');
            String first = path.substring(0, index);
            String last = path.substring(index + 1);
            String dir = path.substring(0, first.lastIndexOf(File.separator));
            try (Stream<Path> pathStream = Files.walk(Paths.get(dir))) {
                for (Path p : pathStream.toList()) {
                    if (p.toString().startsWith(first) && p.toString().endsWith(last)) {
                        paths.add(String.valueOf(p));
                    }
                }
            } catch (Exception ignored) {
            }
        } else {
            paths.add(path);
        }
        return paths;
    }
}
