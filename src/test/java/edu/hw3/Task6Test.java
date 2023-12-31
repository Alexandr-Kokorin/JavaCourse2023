package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.Market;
import edu.hw3.task6.StockMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestStockMarket")
public class Task6Test {

    @Test
    @DisplayName("Test - \"add 2\", expected - \"2\"")
    void stockMarket_Add2_Expected2() {
        StockMarket market = new Market();
        Stock stock = new Stock(2);

        market.add(stock);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(new Stock(2));
    }

    @Test
    @DisplayName("Test - \"add 2, 3\", expected - \"3\"")
    void stockMarket_Add2Add3_Expected3() {
        StockMarket market = new Market();
        Stock stock1 = new Stock(2);
        Stock stock2 = new Stock(3);

        market.add(stock1);
        market.add(stock2);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(new Stock(3));
    }

    @Test
    @DisplayName("Test - \"add 2, 3; remove 3\", expected - \"2\"")
    void stockMarket_Add2Add3Remove3_Expected2() {
        StockMarket market = new Market();
        Stock stock1 = new Stock(2);
        Stock stock2 = new Stock(3);

        market.add(stock1);
        market.add(stock2);
        market.remove(stock2);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(new Stock(2));
    }

    @Test
    @DisplayName("Test - \"add null\", expected - \"null\"")
    void stockMarket_AddNull_ExpectedNull() {
        StockMarket market = new Market();

        market.add(null);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(null);
    }

    @Test
    @DisplayName("Test - \"remove 2\", expected - \"null\"")
    void stockMarket_Remove2_ExpectedNull() {
        StockMarket market = new Market();
        Stock stock = new Stock(2);

        market.remove(stock);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(null);
    }

    @Test
    @DisplayName("Test - \"add 2, null\", expected - \"2\"")
    void stockMarket_Add2AddNull_Expected2() {
        StockMarket market = new Market();
        Stock stock1 = new Stock(2);

        market.add(stock1);
        market.add(null);
        Stock result = market.mostValuableStock();

        assertThat(result).isEqualTo(new Stock(2));
    }
}
