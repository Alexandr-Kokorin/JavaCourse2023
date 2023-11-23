package edu.project3.renderer;

import edu.project3.DataForRender;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Renderer {

    Map<String, String> CODES = new HashMap<>() {{
        put("404", "Not Found");
        put("304", "Not Modified");
        put("200", "OK");
        put("206", "Partial Content");
        put("403", "Forbidden");
        put("416", "Range Not Satisfiable");
    }};

    String renderGeneralInformation(String files, String start, String end, int count, long averageTime);

    String renderRequestedResources(List<DataForRender> resources);

    String renderResponseCodes(List<DataForRender> codes);

    String renderResponseIPAddresses(List<DataForRender> ipAddresses);

    String renderResponseRequests(List<DataForRender> requests);
}
