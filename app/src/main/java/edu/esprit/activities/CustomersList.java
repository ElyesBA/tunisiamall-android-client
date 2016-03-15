package edu.esprit.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import edu.esprit.adapters.UserAdapter;
import edu.esprit.entities.User;
import edu.esprit.fragments.UserInfoDialog;

public class CustomersList extends AppCompatActivity {
    UserAdapter adapter;
    ArrayList<User> usersList;
    static User selectedUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list);
        populateUsersList();
    }

    private void populateUsersList() {
        usersList = new ArrayList<>();
        adapter = new UserAdapter(this, usersList);
        ListView listView = (ListView) findViewById(R.id.lvUsers);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                selectedUser = usersList.get(position);
                mode.getMenu().getItem(0).setTitle(selectedUser.firstName + " " + selectedUser.lastName);
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.add_friend:
                        usersList.remove(selectedUser);
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    case R.id.see_info:
                        FragmentManager fm = getSupportFragmentManager();
                        UserInfoDialog editNameDialog = UserInfoDialog.newInstance(selectedUser);
                        editNameDialog.show(fm, "fragment_user_details");
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.users_context_menu, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });

        User user = new User();
        user.gender = "m";
        user.firstName = "Elyes";
        user.lastName = "Ben Abdelkader";
        usersList.add(user);
        user = new User();
        user.gender = "f";
        user.firstName = "Nourhene";
        user.lastName = "Ben Abdelkader";
        usersList.add(user);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.users_context_menu, menu);
    }
}
