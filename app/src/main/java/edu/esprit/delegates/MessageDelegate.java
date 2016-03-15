package edu.esprit.delegates;

import java.util.ArrayList;
import java.util.Date;

import edu.esprit.entities.Message;
import edu.esprit.entities.User;

public class MessageDelegate {
    public static ArrayList<Message> inboxList = null;

    public static ArrayList<Message> findAll(){
        if(inboxList == null){
            inboxList = new ArrayList<>();
            User u = new User();
            u.setIdUser(1);
            u.setFirstName("Foulena");
            u.setLastName("Ben Foulena");
            u.setGender("f");
            User u2 = new User();
            u2.setIdUser(2);
            u2.setFirstName("Foulen");
            u2.setLastName("Ben Foulen");
            u2.setGender("m");
            Message m = new Message();
            m.setIdMessage(1);
            m.setDate(new Date());
            m.setSender(u);
            m.setReceiver(u2);
            m.setText("Hello world");
            inboxList.add(m);
            m = new Message();
            m.setIdMessage(2);
            m.setDate(new Date());
            m.setSender(u2);
            m.setReceiver(u);
            m.setText("Wksdjf kjsdkf kosdjf iojoi ezjfioj dsoijf ojsoifdjqsodi oj");
            inboxList.add(m);
        }
        return  inboxList;
    }

    public static ArrayList<Message> getChat(){
        if(inboxList == null){
            inboxList = new ArrayList<>();
            User u = new User();
            u.setIdUser(1);
            u.setFirstName("Foulena");
            u.setLastName("Ben Foulena");
            u.setGender("f");
            User u2 = new User();
            u2.setIdUser(2);
            u2.setFirstName("Foulen");
            u2.setLastName("Ben Foulen");
            u2.setGender("m");
            Message m = new Message();
            m.setIdMessage(1);
            m.setDate(new Date());
            m.setSender(u);
            m.setReceiver(u2);
            m.setText("Hello");
            inboxList.add(m);
            m = new Message();
            m.setIdMessage(2);
            m.setDate(new Date());
            m.setSender(u2);
            m.setReceiver(u);
            m.setText("Ahla bik");
            inboxList.add(m);
        }
        return  inboxList;
    }
}
