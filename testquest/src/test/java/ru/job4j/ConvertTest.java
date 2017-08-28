package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aleks on 21.08.2017.
 */
public class ConvertTest {
    @Test
    public void whenNodeRootSameTmpRoot() {
        Node root = new Node(3, 2 ,1);
        Node tmp = new Node(1, 2, 3);
        Convert convert = new Convert();
        Node expected = convert.convert(root);
        assertThat(expected, is(tmp));
    }
}