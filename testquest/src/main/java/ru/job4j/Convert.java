package ru.job4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aleks on 21.08.2017.
 */
public class Convert {
    public Node convert(Node root) {
        for (int index = 0; index < 2; index++) {
            int tmp;
            if (root.valueOne > root.valueTwo) {
                tmp = root.valueOne;
                root.valueOne = root.valueTwo;
                root.valueTwo = tmp;
                if (root.valueTwo > root.valueThree) {
                    tmp = root.valueTwo;
                    root.valueTwo = root.valueThree;
                    root.valueThree = tmp;
                }
            }
        }
        return root;
    }
}
