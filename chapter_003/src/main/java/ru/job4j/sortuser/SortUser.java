package ru.job4j.sortuser;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort (List<User> user){
        Set<User> users = new TreeSet<>();
        for (User userList : user){
            users.add(new User(userList.getName(), userList.getAge()));
        }
        return users;
    }
}
