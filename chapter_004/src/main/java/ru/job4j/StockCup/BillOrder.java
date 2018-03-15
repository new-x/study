package ru.job4j.StockCup;

import java.util.*;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 07.03.2018 21:04
 */

public class BillOrder<E> {
    protected static final String[] BOOKS = {"ГазПром", "Лукойл", "Роснефть", "Макдональдс", "Apple", "Альфабет"};
    protected static final String[] TYPE = {"add", "delete"}; // 0 - add; 1 - delete;
    protected static final String[] ACTION = {"sale", "buy"}; // 0 - sale; 1 - buy;
    protected List<Order> saleOrders = new LinkedList<>();
    protected List<Order> buyOrders = new LinkedList<>();
    protected int genId = 0;

    public void createOrder(String book, String type, String action, int price, int volume) {
        Order order = new Order(genId += 8, book, action, price, volume);
        if (TYPE[0].equals(type)) { // 0 - addOrder
            addOrder(order, action);
            checkOrder();
        }
        if (TYPE[1].equals(type)) { // 1 - deleteOrder
            deleteOrder(getIndexByID(order.id), action);
        }

    }

    public void addOrder(Order order, String action) {
        if (ACTION[0].equals(action)) { //0 - addOrder with type "sale".
            saleOrders.add(order);
            Collections.sort(saleOrders);
        }
        if (ACTION[1].equals(action)) { // 1 - addOrder with type "buy".
            buyOrders.add(order);
            Collections.sort(buyOrders);
        }
    }

    public void deleteOrder(int index, String action) {
        if (ACTION[0].equals(action)) {
            if (index < saleOrders.size()) {
                saleOrders.remove(index);
            } else {
                throw new NoSuchElementException("No such Order in Billing.");
            }
        }
        if (ACTION[1].equals(action)) {
            if (index < buyOrders.size()) {
                buyOrders.remove(index);
            } else {
                throw new NoSuchElementException("No such Order in Billing.");
            }
        }
    }

    public int getIndexByID(int id) {
        for (int indexSale = 0; indexSale < saleOrders.size(); indexSale++) {
            if (id == saleOrders.get(indexSale).id) {
                return indexSale;
            }
        }
        for (int indexBuy = 0; indexBuy < buyOrders.size(); indexBuy++) {
            if (id == buyOrders.get(indexBuy).id) {
                return indexBuy;
            }
        }
        throw new NoSuchElementException("Nothing was found for this id.");
    }

    public void checkOrder() {
        for (int indexSale = 0; indexSale < saleOrders.size(); indexSale++) {
            Order saleOrder = saleOrders.get(indexSale);
            for (int indexBuy = 0; indexBuy < buyOrders.size(); indexBuy++) {
                Order buyOrder = buyOrders.get(indexBuy);
                if (saleOrder.equals(buyOrder)) {
                    if (saleOrder.price <= buyOrder.price) {
                        int volume = saleOrder.volume - buyOrder.volume;
                        if (volume > 0) { //change Order in saleOrders and delete Order in buyOrders
                            saleOrder.volume = volume;
                            deleteOrder(indexBuy, ACTION[1]);
                            indexBuy--;
                        }
                        if (volume == 0) { //delete Order in saleOrders and delete Order in buyOrders.
                            deleteOrder(indexSale, ACTION[0]);
                            deleteOrder(indexBuy, ACTION[1]);
                            indexSale--;
                            indexBuy--;
                        }
                        if (volume < 0) { //delete Order in saleOrders and change Order in buyOrders.
                            buyOrder.volume = volume * -1;
                            deleteOrder(indexSale, ACTION[0]);
                            indexSale--;
                        }
                    }
                }
            }
        }
    }
}
