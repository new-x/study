package ru.job4j.Threads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 12.05.2018 22:20
 */


public class ParallelSearch extends SimpleFileVisitor {
    private final Path root;
    private final String text;
    private final List<String> exts;
    private final BlockingQueue<Path> files = new ArrayBlockingQueue(10);
    private final ConcurrentHashMap<Path, Integer> paths = new ConcurrentHashMap<>();
    private volatile boolean finish = false;


    public ParallelSearch(Path root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void init() throws InterruptedException {
        Thread search = new Thread() {
            @Override
            public void run() {
                MyFileVisitor search = new MyFileVisitor();
                try {
                    Files.walkFileTree(root, search);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish = true;
            }
        };

        Thread read = new Thread() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    Path file = null;
                    try {
                        file = files.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8);
                            for (String line : lines) {
                                if (line.contains(text)) {
                                    if (paths.containsKey(file)) {
                                        paths.replace(file, paths.get(file), 1 + paths.get(file));
                                    }
                                    paths.putIfAbsent(file, 1);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    if (files.isEmpty() && finish) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        search.start();
        read.start();
        read.join();
    }

    public ConcurrentHashMap<Path, Integer> result() throws InterruptedException {
        init();
        return paths;
    }

    public class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            if (attrs.isRegularFile()) {
                for (String exts : exts) {
                    if (path.toString().endsWith(exts)) {
                        try {
                            files.put(path);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
