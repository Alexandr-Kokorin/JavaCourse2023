package edu.project3.renderer;

import java.util.Map;

public interface Renderer {

    String renderGeneralInformation(String files, String startDate, String endDate, int count, int averageTime);

    String renderRequestedResources(Map<String, Integer> resources);

    String renderResponseCodes(Map<Integer, Integer> codes);

    //...
}
