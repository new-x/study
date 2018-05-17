package ru.job4j.Threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 12.05.2018 22:20
 */


@ThreadSafe
public class ParallelSearch extends SimpleFileVisitor {
    private final Path root;
    private final String text;
    private final List<String> exts;
    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Path> files = new ConcurrentLinkedQueue<>();
    @GuardedBy("this")
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
                    if (files.peek() != null) {
                        Path file = files.poll();
                        try {
                            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8);
                            for (String line : lines) {
                                if (line.equals(text)) {
                                    if (!paths.containsKey(file)) {
                                        paths.putIfAbsent(file, 1);
                                    } else {
                                        Integer value = paths.get(file);
                                        paths.replace(file, value, ++value);
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

    public synchronized ConcurrentHashMap<Path, Integer> result() throws InterruptedException {
        init();
        return paths;
    }

    public class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            if (attrs.isRegularFile()) {
                for (String exts : exts) {
                    if (path.toString().endsWith(exts)) {
                        files.add(path);
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
