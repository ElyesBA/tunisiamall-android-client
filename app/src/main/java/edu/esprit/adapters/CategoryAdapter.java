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
import edu.esprit.entities.Category;
import edu.esprit.entities.User;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category c = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_category, parent, false);
        }
        TextView label = (TextView) convertView.findViewById(R.id.category_label);
        label.setText(c.libelle);
        return convertView;
    }
}
