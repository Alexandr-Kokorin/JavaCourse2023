package edu.project3.renderer;

import edu.project3.DataForRender;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class RendererAdoc implements  Renderer {

    @Override
    public String renderGeneralInformation(String files, String start, String end, int count, long averageTime) {
        return "==== Общая информация\n\n"
             + "|===\n"
             + "|Метрика |Значение\n\n"
             + "|Файл(-ы)\n"
             + "|" + files + "\n\n"
             + "|Начальная дата\n"
             + "|" + start + "\n\n"
             + "|Конечная дата\n"
             + "|" + end + "\n\n"
             + "|Количество запросов\n"
             + "|" + count + "\n\n"
             + "|Средний размер ответа\n"
             + "|" + averageTime + "\n"
             + "|===\n";
    }

    @Override
    public String renderRequestedResources(List<DataForRender> resources) {
        StringBuilder builder = new StringBuilder("==== Запрашиваемые ресурсы\n\n");
        builder.append("|===\n");
        builder.append("|Ресурс |Количество\n\n");
        for (DataForRender data : resources) {
            builder.append("|").append(data.name()).append("\n");
            builder.append("|").append(data.count()).append("\n\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("|===\n");
        return builder.toString();
    }

    @Override
    public String renderResponseCodes(List<DataForRender> codes) {
        StringBuilder builder = new StringBuilder("==== Коды ответа\n\n");
        builder.append("|===\n");
        builder.append("|Код |Имя |Количество\n\n");
        for (DataForRender data : codes) {
            builder.append("|").append(data.name()).append("\n");
            builder.append("|").append(CODES.get(data.name())).append("\n");
            builder.append("|").append(data.count()).append("\n\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("|===\n");
        return builder.toString();
    }

    @Override
    public String renderResponseIPAddresses(List<DataForRender> ipAddresses) {
        StringBuilder builder = new StringBuilder("==== IP адреса\n\n");
        builder.append("|===\n");
        builder.append("|IP адрес |Количество\n\n");
        for (DataForRender data : ipAddresses) {
            builder.append("|").append(data.name()).append("\n");
            builder.append("|").append(data.count()).append("\n\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("|===\n");
        return builder.toString();
    }

    @Override
    public String renderResponseRequests(List<DataForRender> requests) {
        StringBuilder builder = new StringBuilder("==== Запросы\n\n");
        builder.append("|===\n");
        builder.append("|Запрос |Количество\n\n");
        for (DataForRender data : requests) {
            builder.append("|").append(data.name()).append("\n");
            builder.append("|").append(data.count()).append("\n\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("|===\n");
        return builder.toString();
    }
}
