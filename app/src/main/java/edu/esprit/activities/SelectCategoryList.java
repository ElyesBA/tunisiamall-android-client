package edu.esprit.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.esprit.adapters.CategoryAdapter;
import edu.esprit.delegates.CategoryDelegate;
import edu.esprit.entities.Category;
import edu.esprit.entities.Subcategory;
import edu.esprit.fragments.CategoryDialog;

public class SelectCategoryList extends AppCompatActivity {
    private ArrayList<Category> CategoriesList;
    private Subcategory subcategory;
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            FragmentManager fm = getSupportFragmentManager();
            CategoryDialog alertDialog = new CategoryDialog().newInstance(CategoriesList.get(position));
            alertDialog.show(fm, "alertDialog");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category_list);
        subcategory.idSubCategory = getIntent(
                CategoriesList = CategoryDelegate.findAll();
        CategoryAdapter adapter = new CategoryAdapter(this, CategoriesList);
        ListView listView = (ListView) findViewById(R.id.lvCategories);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mMessageClickedHandler);
    }
}
