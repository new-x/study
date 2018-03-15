package ru.job4j.StockCup;

import org.junit.Test;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 07.03.2018 21:41
 */
public class BillOrderTest {
    @Test
    public void whenAddOrderTrue() {
        SortedOrders sortedOrders =  new SortedOrders();
        BillOrder<Order> billOrder = new BillOrder<>();
        //billOrder.createOrder("ГазПром", "add", "sale", 10, 10);
        //billOrder.createOrder("ГазПром", "add", "sale", 10, 10);
        billOrder.createOrder("ГазПром", "add", "sale", 10, 10);
        billOrder.createOrder("ГазПром", "add", "sale", 10, 10);
        billOrder.createOrder("ГазПром", "add", "sale", 10, 10);
        billOrder.createOrder("ГазПром", "add", "buy", 10, 20);
        billOrder.createOrder("Роснефть", "add", "buy", 10, 20);
        billOrder.createOrder("Лукойл", "add", "sale", 10, 10);
        billOrder.createOrder("Роснефть", "add", "buy", 10, 10);
        //billOrder.checkOrder();
        System.out.println(billOrder.saleOrders.get(0));
        System.out.println(billOrder.saleOrders.get(1));
        System.out.println(billOrder.buyOrders.get(0));
        System.out.println(billOrder.buyOrders.get(1));
        //billOrder.deleteOrder(billOrder.getIndexByID(40), "buy");
        //System.out.println(billOrder.buyOrders.get(0));
        //sortedOrders.sortOrders();
        System.out.println(sortedOrders.getSize());
        sortedOrders.printOrders();
    }
}
