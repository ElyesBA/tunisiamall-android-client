package edu.esprit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import edu.esprit.activities.R;
import edu.esprit.entities.User;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
        ImageView icon = (ImageView) convertView.findViewById(R.id.userItemIcon);
        TextView name = (TextView) convertView.findViewById(R.id.userItemName);
        if(user.getGender() == "m"){
            icon.setImageResource(R.drawable.user_male);
        }
        else{
            icon.setImageResource(R.drawable.user_female);
        }
        name.setText(user.getFirstName() + " " + user.getLastName());
        return convertView;
    }
}
