package edu.esprit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.esprit.delegates.UserDelegate;
import edu.esprit.entities.User;

public class ClientMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);
        User u = new UserDelegate().find(1);
        System.out.println("#######" + u.getFirstName() + " " + u.getLastName());
    }

    public void clientCart(View v){
        Intent i = new Intent();
        startActivity(i);
    }

    public void clientGuestbook(View v){
        Intent i = new Intent();
        startActivity(i);
    }

    public void clientStore(View v){
        Intent i = new Intent();
        startActivity(i);
    }

    public void clientEvent(View v){
        Intent i = new Intent();
        startActivity(i);
    }

    public void clientFriend(View v){
        Intent i = new Intent(ClientMenu.this, CustomersList.class);
        startActivity(i);
    }

    public void clientChat(View v){
        Intent i = new Intent(ClientMenu.this, Inbox.class);
        startActivity(i);
    }
}
