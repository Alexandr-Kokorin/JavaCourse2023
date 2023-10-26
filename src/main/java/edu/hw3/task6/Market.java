package edu.hw3.task6;

import java.util.Objects;
import java.util.PriorityQueue;

public class Market implements StockMarket {

    private final PriorityQueue<Stock> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.price() - o1.price());

    @Override
    public void add(Stock stock) {
        if (!Objects.isNull(stock)) {
            priorityQueue.add(stock);
        }
    }

    @Override
    public void remove(Stock stock) {
        priorityQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
