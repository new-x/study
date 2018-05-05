package ru.job4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 03.05.2018 23:28
 */
// мама маам
public class WorldChecking {
    public boolean checkWorld(String worldOne, String worldTwo) {
        HashMap<Character, Integer> mapOne = new HashMap<>();
        char[] worldTwoSymbols = worldTwo.toCharArray();
        if (worldOne.length() != worldTwo.length()) {
        return false;
        }
        for (int index = 0; index < worldOne.length(); index++) {
            if (mapOne.containsKey(worldOne.charAt(index))) {
                Integer valueOne = mapOne.get(worldOne.charAt(index));
                mapOne.replace(worldOne.charAt(index), ++valueOne);
            } else {
                mapOne.put(worldOne.charAt(index), 1);
            }
        }
        for (Map.Entry map : mapOne.entrySet()) {
            char symbol = (char) map.getKey();
            Integer countSymbols = (Integer) map.getValue();
            Integer count = 0;
            for (char ch : worldTwoSymbols) {
                if (symbol == ch) {
                    count++;
                }
            }
            if (countSymbols != count) {
                return false;
            }
        }
        return  true;
    }

}
