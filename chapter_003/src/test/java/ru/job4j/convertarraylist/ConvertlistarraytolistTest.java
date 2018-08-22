package ru.job4j.convertarraylist;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aleks on 15.09.2017.
 */
public class ConvertlistarraytolistTest {
        @Test
        public void converListArrayToList(){
            Convertlistarraytolist convertlistarraytolist = new Convertlistarraytolist();
            List<int[]> list = new LinkedList<>();
            list.add(new int[]{1, 2});
            list.add(new int[]{3, 4, 5, 6});
            list.add(new int[]{1, 6, 3, 10});
            List<Integer> result = convertlistarraytolist.convert(list);
        }

}
