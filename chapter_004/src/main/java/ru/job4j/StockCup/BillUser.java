package ru.job4j.StockCup;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 10.03.2018 17:58
 */

public class BillUser {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        SortedOrders sortedOrders =  new SortedOrders();
        while (true) {
            System.out.println(sortedOrders.getSize());
            userInput.addOrDelete();
            System.out.println(sortedOrders.getSize());
            sortedOrders.sortOrders();
        }

    }
}
