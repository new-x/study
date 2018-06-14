package ru.job4j.Threads;

import java.util.Objects;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.Threads
 * Create data: 25.05.2018 17:58
 */

public class Base {
    private String name;
    private Integer version;

    public Base(String name, Integer version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Base{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(version, base.version);
    }

    @Override
    public int hashCode() {

        return Objects.hash(version);
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }
}