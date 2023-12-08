package edu.project3.renderer;

import edu.project3.DataForRender;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class RendererMarkdown implements Renderer {

    @Override
    public String renderGeneralInformation(String files, String start, String end, int count, long averageTime) {
        return "#### Общая информация\n\n"
             + "| Метрика | Значение |\n"
             + "|---------|----------|\n"
             + "| Файл(-ы) | " + files + " |\n"
             + "| Начальная дата | " + start + " |\n"
             + "| Конечная дата | " + end + " |\n"
             + "| Количество запросов | " + count + " |\n"
             + "| Средний размер ответа | " + averageTime + " |\n";
    }

    @Override
    public String renderRequestedResources(List<DataForRender> resources) {
        StringBuilder builder = new StringBuilder("#### Запрашиваемые ресурсы\n\n");
        builder.append("| Ресурс | Количество |\n");
        builder.append("|--------|------------|\n");
        for (DataForRender data : resources) {
            builder.append("| ").append(data.name()).append(" | ");
            builder.append(data.count()).append(" |\n");
        }
        return builder.toString();
    }

    @Override
    public String renderResponseCodes(List<DataForRender> codes) {
        StringBuilder builder = new StringBuilder("#### Коды ответа\n\n");
        builder.append("| Код | Имя | Количество |\n");
        builder.append("|-----|-----|------------|\n");
        for (DataForRender data : codes) {
            builder.append("| ").append(data.name()).append(" | ");
            builder.append(CODES.get(data.name())).append(" | ");
            builder.append(data.count()).append(" |\n");
        }
        return builder.toString();
    }

    @Override
    public String renderResponseIPAddresses(List<DataForRender> ipAddresses) {
        StringBuilder builder = new StringBuilder("#### IP адреса\n\n");
        builder.append("| IP адрес | Количество |\n");
        builder.append("|-------|------------|\n");
        for (DataForRender data : ipAddresses) {
            builder.append("| ").append(data.name()).append(" | ");
            builder.append(data.count()).append(" |\n");
        }
        return builder.toString();
    }

    @Override
    public String renderResponseRequests(List<DataForRender> requests) {
        StringBuilder builder = new StringBuilder("#### Запросы\n\n");
        builder.append("| Запрос | Количество |\n");
        builder.append("|--------|------------|\n");
        for (DataForRender data : requests) {
            builder.append("| ").append(data.name()).append(" | ");
            builder.append(data.count()).append(" |\n");
        }
        return builder.toString();
    }
}
