package edu.project3;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCalculator {

    public String getFiles(List<String> paths) {
        StringBuilder string = new StringBuilder();
        for (String path : paths) {
            string.append("'")
                .append(path.substring(path.indexOf(File.separator) + File.separator.length()))
                .append("', ");
        }
        return string.delete(string.length() - 2, string.length()).toString();
    }

    public String getStartDate(List<LogEntry> logs) {
        return logs.get(0).timestamp().toLocalDate().toString();
    }

    public String getEndDate(List<LogEntry> logs) {
        return logs.get(logs.size() - 1).timestamp().toLocalDate().toString();
    }

    public int getCountLogs(List<LogEntry> logs) {
        return logs.size();
    }

    public long getAverageTime(List<LogEntry> logs) {
        long sum = 0;
        for (LogEntry log : logs) {
            sum += log.responseSize();
        }
        return sum / logs.size();
    }

    public List<DataForRender> getResources(List<LogEntry> logs) {
        Map<String, Integer> map = new HashMap<>();
        for (LogEntry log : logs) {
            String[] tmp = log.requestLine().split(" ");
            map.put(tmp[1], map.getOrDefault(tmp[1], 0) + 1);
        }
        return getData(map);
    }

    public List<DataForRender> getCodes(List<LogEntry> logs) {
        Map<String, Integer> map = new HashMap<>();
        for (LogEntry log : logs) {
            map.put(String.valueOf(log.statusCode()), map.getOrDefault(String.valueOf(log.statusCode()), 0) + 1);
        }
        return getData(map);
    }

    public List<DataForRender> getIPAddresses(List<LogEntry> logs) {
        Map<String, Integer> map = new HashMap<>();
        for (LogEntry log : logs) {
            map.put(log.ipAddress(), map.getOrDefault(log.ipAddress(), 0) + 1);
        }
        return getData(map);
    }

    public List<DataForRender> getRequests(List<LogEntry> logs) {
        Map<String, Integer> map = new HashMap<>();
        for (LogEntry log : logs) {
            String[] tmp = log.requestLine().split(" ");
            map.put(tmp[0], map.getOrDefault(tmp[0], 0) + 1);
        }
        return getData(map);
    }

    private List<DataForRender> getData(Map<String, Integer> map) {
        List<DataForRender> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(new DataForRender(key, map.get(key)));
        }
        result.sort(Comparator.comparingInt(DataForRender::count).reversed());
        return result;
    }
}
