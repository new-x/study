package ru.job4j.Threads;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 13.05.2018 12:09
 */

public class ParallelSearchTest {
    @Test
    public void testMethod() throws IOException, InterruptedException {
        Path root = Paths.get("C:\\Storage\\Java\\study\\chapter_004\\src\\main\\java\\ru\\job4j\\Threads\\files");
        String txt = "text";
        List<String> exts = new LinkedList<>();
        exts.add(".txt");
        exts.add(".php");
        ParallelSearch parallelSearch = new ParallelSearch(root, txt, exts);
        ConcurrentHashMap<Path, Integer> paths = parallelSearch.result();
        for (Map.Entry<Path, Integer> path : paths.entrySet()) {
            System.out.println(path.getKey() + " Совпадений:" + path.getValue());
        }
    }
}
