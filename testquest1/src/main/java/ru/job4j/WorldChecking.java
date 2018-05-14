package ru.job4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 03.05.2018 23:28
 */

public class WorldChecking {
    public boolean checkWorld(String worldOne, String worldTwo) {
        HashMap<Character, Integer> mapOne = new HashMap<>();
        char[] worldTwoSymbols = worldTwo.toCharArray();

        if (worldOne.length() != worldTwo.length()) {
            return false;
        }

        for (int index = 0; index < worldOne.length(); index++) {
            mapOne.computeIfPresent(worldOne.charAt(index), (key, value) -> ++value);
            if (!mapOne.containsKey(worldOne.charAt(index))) {
                mapOne.put(worldOne.charAt(index), 1);
            }
        }

        for (Map.Entry map : mapOne.entrySet()) {
            Integer count = 0;
            for (char ch : worldTwoSymbols) {
                if ((char) map.getKey() == ch) {
                    count++;
                }
            }
            if (map.getValue() != count) {
                return false;
            }
        }
        return true;
    }

}
