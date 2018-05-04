package ru.job4j;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 03.05.2018 23:28
 */
// мама маам
public class WorldChecking {
    public boolean checkWorld(StringBuilder worldOne, StringBuilder worldTwo) {
        if (worldOne.length() == worldTwo.length()) {
            for (int indexOne = 0; indexOne < worldOne.length(); indexOne++) {
                if (worldOne.charAt(indexOne) != worldTwo.charAt(indexOne)) {
                    for (int indexTwo = indexOne; indexTwo < worldTwo.length(); indexTwo++) {
                        if (worldOne.charAt(indexOne) == worldTwo.charAt(indexTwo)) {
                            char symbol = worldTwo.charAt(indexOne);
                            worldTwo.setCharAt(indexOne, worldTwo.charAt(indexTwo));
                            worldTwo.setCharAt(indexTwo, symbol);
                            break;
                        }
                    }
                }
            }
        }
        return worldOne.toString().equals(worldTwo.toString()) ? true : false;
    }

}
