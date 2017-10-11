package ru.job4j.sortuser;

import java.util.*;

public class SortUser {
    public Set<User> sort (List<User> user){
        Set<User> users = new TreeSet<>();
        for (User userList : user){
            users.add(new User(userList.getName(), userList.getAge()));
        }
        return users;
    }

    public List<User> sortNameLength (List<User> user){
        user.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getNameLenght().compareTo(o2.getNameLenght());
                    }
                }
        );
        return user;
    }

    public List<User> sortByAllFields (List<User> user){
        user.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        );
        user.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getAge().compareTo(o2.getAge());
                    }
                }
        );

        return user;
    }
}
