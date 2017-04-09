package ru.job4j.calculator;

/**
* Class Calculator - Тип данных.
* @author alekseev
* @since 1.0
*/

public class Calculator {

	/**
	* Переменная для хранения результатов вычислений.
	*/
    private double result;

    /**
     * Сложение.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычетание.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление.
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Возвращает значение поля класса.
     * @return result возвращаемое значение
     */
    public double getResult() {
        return this.result;
    }
}
