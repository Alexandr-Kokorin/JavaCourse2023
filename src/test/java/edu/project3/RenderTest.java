package edu.project3;

import edu.project3.renderer.RendererAdoc;
import edu.project3.renderer.RendererMarkdown;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RenderTest {

    private final static DataCalculator DATA_CALCULATOR = new DataCalculator();
    private final static RendererMarkdown RENDERER_MARKDOWN = new RendererMarkdown();
    private final static RendererAdoc RENDERER_ADOC = new RendererAdoc();

    private final static List<LogEntry> LOGS = Main.getLogs("logs" + File.separator + "2015-05-24.txt", null, null);

    static Arguments[] markdown() {
        return new Arguments[] {
            Arguments.of(
                RENDERER_MARKDOWN.renderGeneralInformation(
                    DATA_CALCULATOR.getFiles(Main.getPaths("logs" + File.separator + "2015-05-24.txt")),
                    DATA_CALCULATOR.getStartDate(LOGS),
                    DATA_CALCULATOR.getEndDate(LOGS),
                    DATA_CALCULATOR.getCountLogs(LOGS),
                    DATA_CALCULATOR.getAverageTime(LOGS)
                ),
                """
                    #### Общая информация

                    | Метрика | Значение |
                    |---------|----------|
                    | Файл(-ы) | '2015-05-24.txt' |
                    | Начальная дата | 2015-05-24 |
                    | Конечная дата | 2015-05-24 |
                    | Количество запросов | 16 |
                    | Средний размер ответа | 326 |
                    """
            ),
            Arguments.of(
                RENDERER_MARKDOWN.renderRequestedResources(DATA_CALCULATOR.getResources(LOGS)),
                """
                    #### Запрашиваемые ресурсы

                    | Ресурс | Количество |
                    |--------|------------|
                    | /downloads/product_1 | 13 |
                    | /downloads/product_2 | 3 |
                    """
            ),
            Arguments.of(
                RENDERER_MARKDOWN.renderResponseCodes(DATA_CALCULATOR.getCodes(LOGS)),
                """
                    #### Коды ответа

                    | Код | Имя | Количество |
                    |-----|-----|------------|
                    | 404 | Not Found | 14 |
                    | 200 | OK | 1 |
                    | 304 | Not Modified | 1 |
                    """
            ),
            Arguments.of(
                RENDERER_MARKDOWN.renderResponseIPAddresses(DATA_CALCULATOR.getIPAddresses(LOGS)),
                """
                    #### IP адреса

                    | IP адрес | Количество |
                    |-------|------------|
                    | 137.117.180.241 | 4 |
                    | 54.171.135.75 | 3 |
                    | 54.77.28.244 | 3 |
                    | 137.117.180.46 | 3 |
                    | 194.58.90.185 | 2 |
                    | 5.63.153.125 | 1 |
                    """
            ),
            Arguments.of(
                RENDERER_MARKDOWN.renderResponseRequests(DATA_CALCULATOR.getRequests(LOGS)),
                """
                    #### Запросы

                    | Запрос | Количество |
                    |--------|------------|
                    | GET | 16 |
                    """
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("markdown")
    void renderMarkdownTest(String test, String excepted) {
        assertThat(test).isEqualTo(excepted);
    }

    static Arguments[] adoc() {
        return new Arguments[] {
            Arguments.of(
                RENDERER_ADOC.renderGeneralInformation(
                    DATA_CALCULATOR.getFiles(Main.getPaths("logs" + File.separator + "2015-05-24.txt")),
                    DATA_CALCULATOR.getStartDate(LOGS),
                    DATA_CALCULATOR.getEndDate(LOGS),
                    DATA_CALCULATOR.getCountLogs(LOGS),
                    DATA_CALCULATOR.getAverageTime(LOGS)
                ),
                """
                    ==== Общая информация

                    |===
                    |Метрика |Значение

                    |Файл(-ы)
                    |'2015-05-24.txt'

                    |Начальная дата
                    |2015-05-24

                    |Конечная дата
                    |2015-05-24

                    |Количество запросов
                    |16

                    |Средний размер ответа
                    |326
                    |===
                    """
            ),
            Arguments.of(
                RENDERER_ADOC.renderRequestedResources(DATA_CALCULATOR.getResources(LOGS)),
                """
                    ==== Запрашиваемые ресурсы

                    |===
                    |Ресурс |Количество

                    |/downloads/product_1
                    |13

                    |/downloads/product_2
                    |3
                    |===
                    """
            ),
            Arguments.of(
                RENDERER_ADOC.renderResponseCodes(DATA_CALCULATOR.getCodes(LOGS)),
                """
                    ==== Коды ответа

                    |===
                    |Код |Имя |Количество

                    |404
                    |Not Found
                    |14

                    |200
                    |OK
                    |1

                    |304
                    |Not Modified
                    |1
                    |===
                    """
            ),
            Arguments.of(
                RENDERER_ADOC.renderResponseIPAddresses(DATA_CALCULATOR.getIPAddresses(LOGS)),
                """
                    ==== IP адреса

                    |===
                    |IP адрес |Количество

                    |137.117.180.241
                    |4

                    |54.171.135.75
                    |3

                    |54.77.28.244
                    |3

                    |137.117.180.46
                    |3

                    |194.58.90.185
                    |2

                    |5.63.153.125
                    |1
                    |===
                    """
            ),
            Arguments.of(
                RENDERER_ADOC.renderResponseRequests(DATA_CALCULATOR.getRequests(LOGS)),
                """
                    ==== Запросы

                    |===
                    |Запрос |Количество

                    |GET
                    |16
                    |===
                    """
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("adoc")
    void renderAdocTest(String test, String excepted) {
        assertThat(test).isEqualTo(excepted);
    }
}
