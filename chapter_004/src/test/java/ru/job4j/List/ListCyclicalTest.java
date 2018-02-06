package ru.job4j.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListCyclicalTest {
    @Test
    public void whenListCyclicalNextOne(){
        ListCyclical<String> ls = new ListCyclical<>();
        Node one = new Node("One");
        Node two = new Node("Two");
        Node three = new Node("Three");
        Node four = new Node("Four");
        Node five = new Node("Five");
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = one;
        assertThat(ls.hasCycle(one), is(true));
    }

    @Test
    public void whenListCyclicalNextThree(){
        ListCyclical<String> ls = new ListCyclical<>();
        Node one = new Node("One");
        Node two = new Node("Two");
        Node three = new Node("Three");
        Node four = new Node("Four");
        Node five = new Node("Five");
        Node six = new Node("Six");
        Node seven = new Node("Seven");
        Node eight = new Node("Eight");
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
        six.next = seven;
        seven.next = eight;
        assertThat(ls.hasCycle(one), is(true));
    }

}
