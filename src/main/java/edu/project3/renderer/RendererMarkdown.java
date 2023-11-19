package edu.project3.renderer;

import java.util.Map;

public class RendererMarkdown implements Renderer {

    @Override
    public String renderGeneralInformation(String files, String startDate, String endDate, int count, int averageTime) {
        return null;
    }

    @Override
    public String renderRequestedResources(Map<String, Integer> resources) {
        return null;
    }

    @Override
    public String renderResponseCodes(Map<Integer, Integer> codes) {
        return null;
    }
}
