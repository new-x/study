package ru.job4j.StockCup;

import java.util.Scanner;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 10.03.2018 19:06
 */

public class UserInput {
    private BillOrder billOrder = new BillOrder();
    private Scanner in = new Scanner(System.in);
    private int volume;
    private int price;
    private int index;

    public void checkInput() {
        while (!in.hasNextInt()) {
            System.out.println("Вы ввели неверное значение.");
            in.next();
        }
        index = in.nextInt();
    }

    public void checkIndex() {
        checkInput();
        while (!(index >= 0 & index <= 1)) {
            System.out.println("Введите пожалуйста 0 или 1.");
            checkInput();
        }
    }

    public void addOrDelete() {
        System.out.println(
                "Введите пожалуйста желаемое действие: \n" +
                        "1. Купить или Продать облигацию. Введите 0. \n" +
                        "2. Удалить созданную заявку. Введите 1.");
        checkIndex();
        if (billOrder.TYPE[0].equals(billOrder.TYPE[index])) {
            saleOrBuyOrder(billOrder.TYPE[0]);
        } else if (billOrder.TYPE[1].equals(billOrder.TYPE[index])) {
            deleteOrder();
        }
    }

    public void deleteOrder() {
        System.out.println(
                "Введите  пожалуйста тип бумаги: \n" +
                        "1. Продажа - 0. \n" +
                        "2. Покупка - 1.");
        checkIndex();
        String action = billOrder.ACTION[index];
        System.out.println("Введите пожалуйтса ID бумаги:");
        checkInput();
        while (!(index > 0)) {
            System.out.println("Введите пожалуйста значение больше 0");
            checkInput();
        }
        billOrder.deleteOrder(billOrder.getIndexByID(index), action);

    }

    public void saleOrBuyOrder(String type) {
        System.out.println(
                "Вы хотите купить или продать облигацию: \n" +
                        "1. Продать облигацию - 0. \n" +
                        "2. Купить облигацию - 1.");
        checkIndex();
        if (billOrder.ACTION[0].equals(billOrder.ACTION[index])) {
            createOrder(type, billOrder.ACTION[0]);
        } else if (billOrder.ACTION[1].equals(billOrder.ACTION[index])) {
            createOrder(type, billOrder.ACTION[1]);
        }
    }

    public void createOrder(String type, String action) {

        System.out.println("Пожалуйста выберите тип бумаги: ");
        for (int index = 0; index < billOrder.BOOKS.length; index++) {
            System.out.println(index + ".\t" + billOrder.BOOKS[index]);
        }

        checkInput();
        while (!(index >= 0 & index < billOrder.BOOKS.length)) {
            System.out.println("Введите пожалуйста тип бумаги. Цифра от 0 до " + (billOrder.BOOKS.length - 1));
            checkInput();
        }

        String book = billOrder.BOOKS[index];

        boolean resultVolume = true;
        while (resultVolume) {
            System.out.println("Пожалуйста укажите количество бумаг, которые хотите продать: \n" +
                    "Значение от 1 до 1000.");
            checkInput();
            this.volume = Integer.valueOf(index);
            if (this.volume > 0 & this.volume <= 1000) {
                resultVolume = false;
            } else {
                System.out.println("Вы ввели неверное значение: \n" +
                        "Укажите количество, которые желаете выставить на продажу. \n " +
                        "Значение от 1 до 1000.");
            }
        }
        boolean resultPrice = true;
        while (resultPrice) {
            System.out.println("Пожалуйста укажите цену за бумаги, которые хотите продать: ");
            checkInput();
            this.price = Integer.valueOf(index);
            if (this.price > 0 & this.price <= 1000) {
                resultPrice = false;
            } else {
                System.out.println("Вы ввели неверное значение: \n" +
                        "Укажите цену за бамаги, которые вы хотите продать. \n " +
                        "Значение от 1 до 1000.");
            }
        }
        billOrder.createOrder(book, type, action, price, volume);
        System.out.println("Заявка создана. Название бумаги: " + book + " - ID бумаги: " + billOrder.genId);
    }
}
