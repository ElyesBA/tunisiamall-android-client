package edu.esprit.delegates;

import java.util.ArrayList;
import edu.esprit.entities.User;

public class UserDelegate {
    public static ArrayList<User> usersList = null;

    public static ArrayList<User> findAll(){
        if(usersList == null){
            usersList = new ArrayList<>();
            User u = new User();
            u.setIdUser(1);
            u.setFirstName("Foulena");
            u.setLastName("Ben Foulena");
            u.setGender("f");
            usersList.add(u);
            u = new User();
            u.setIdUser(2);
            u.setFirstName("Foulen");
            u.setLastName("Ben Foulen");
            u.setGender("m");
            usersList.add(u);
        }
        return  usersList;
    }
}
