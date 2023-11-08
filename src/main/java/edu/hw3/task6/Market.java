package edu.hw3.task6;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Market implements StockMarket {

    private final PriorityQueue<Stock> stocks = new PriorityQueue<>(Comparator.comparing(Stock::price).reversed());

    @Override
    public void add(Stock stock) {
        if (!Objects.isNull(stock)) {
            stocks.add(stock);
        }
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
