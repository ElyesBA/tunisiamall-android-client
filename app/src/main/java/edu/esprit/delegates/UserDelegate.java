package edu.esprit.delegates;

import java.util.ArrayList;
import edu.esprit.entities.User;

public class UserDelegate {
    public static ArrayList<User> usersList = null;

    public static ArrayList<User> findAll(){
        if(usersList == null){
            usersList = new ArrayList<>();
            User u = new User();
            u.firstName = "Foulena";
            u.lastName = "Ben Foulena";
            u.gender = "f";
            usersList.add(u);
            u = new User();
            u.firstName = "Foulen";
            u.lastName = "Ben Foulen";
            u.gender = "m";
            usersList.add(u);
        }
        return  usersList;
    }
}
