package edu.esprit.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.esprit.activities.R;
import edu.esprit.entities.Category;
import edu.esprit.entities.Subcategory;

public class SubCategoryAdapter extends ArrayAdapter<Subcategory> {

    public SubCategoryAdapter(Context context, ArrayList<Subcategory> subcategories) {
        super(context, 0, subcategories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Subcategory s = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_subcategory, parent, false);
        }
        TextView description = (TextView) convertView.findViewById(R.id.sub_cat_description);
        TextView label = (TextView) convertView.findViewById(R.id.sub_cat_lab);
        description.setText(s.getDescription());
        label.setText(s.getLibelle());
        return convertView;
    }
}
