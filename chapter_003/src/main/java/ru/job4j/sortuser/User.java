package ru.job4j.sortuser;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (this.age == o.age & this.name.equals(o.name)){
            return 0;
        }
        if (this.age == o.age){
            return this.name.compareTo(o.name);
        }
        else {
            return this.age.compareTo(o.age);
        }
    }
}
