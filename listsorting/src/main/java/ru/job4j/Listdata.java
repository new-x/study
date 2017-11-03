package ru.job4j;

public class Listdata implements Comparable<Listdata> {
    private String department;
    private String service;
    private String section;

    public Listdata(String department) {
        this.department = department;
    }

    public Listdata(String department, String service) {
        this.department = department;
        this.service = service;
    }

    public Listdata(String department, String service, String section) {
        this.department = department;
        this.service = service;
        this.section = section;
    }

    @Override
    public int compareTo(Listdata o) {
        return 0;
    }
}
