package ru.job4j.StockCup;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 13.03.2018 11:27
 */

public class SortedOrders {
    private BillOrder billOrder = new BillOrder();
    private List<Order> sortedOrders = new LinkedList<>();

    public int getSize() {
        return sortedOrders.size();
    }

    public void sortOrders() {
        sortedOrders.addAll(billOrder.saleOrders);
        sortedOrders.addAll(billOrder.buyOrders);
        Collections.sort(sortedOrders);
    }

    public void printOrders() {
        System.out.println("Название \t" + "Продажа \t" + "Цена \t" + "Покупка \t");
        for (Order order : sortedOrders) {
            if (order.action.equals(billOrder.ACTION[0])) {
                System.out.println(order.book + "\t" + "       \t" + order.price + "$\t" + order.volume + "шт.");
            } else if (order.action.equals(billOrder.ACTION[1])) {
                System.out.println(order.book + "\t" + order.volume + "шт.\t" + order.price + "$\t");
            }
        }
    }
}
