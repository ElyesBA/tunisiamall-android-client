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
import edu.esprit.entities.Message;
import edu.esprit.entities.User;

public class InboxAdapter extends ArrayAdapter<Message> {

    public InboxAdapter(Context context, ArrayList<Message> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message m = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_inbox, parent, false);
        }
        TextView user = (TextView) convertView.findViewById(R.id.inbox_user);
        TextView text = (TextView) convertView.findViewById(R.id.inbox_text);
        TextView date = (TextView) convertView.findViewById(R.id.inbox_date);
        user.setText(m.getSender().getFirstName() + " " + m.getSender().getLastName());
        text.setText(m.getText());
        date.setText(m.getDate().toString());
        return convertView;
    }
}
