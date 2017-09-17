package ru.job4j.convertlisttomap;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aleks on 17.09.2017.
 */
public class Convertlisttomap {

    public HashMap<Integer, User> convertUser(List<User> list){
        HashMap<Integer, User> mapUser = new HashMap<>();
        for (int index = 0; index < list.size(); index++){
            mapUser.put(list.get(index).id, new User(list.get(index).name));
        }
    return mapUser;
    }
}
