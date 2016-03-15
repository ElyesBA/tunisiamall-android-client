package edu.esprit.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.esprit.adapters.CategoryAdapter;
import edu.esprit.adapters.SubCategoryAdapter;
import edu.esprit.delegates.CategoryDelegate;
import edu.esprit.delegates.SubCategoryDelegate;
import edu.esprit.entities.Category;
import edu.esprit.entities.Subcategory;
import edu.esprit.fragments.CategoryDialog;

public class SelectCategoryList extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<Category> CategoriesList;
    Activity activity;
    ListView listView;
    CategoryAdapter adapter;
    AlertDialog.Builder alertDialogBuilder;
    Subcategory subcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category_list);
        initilize();
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) activity);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentManager fm = getSupportFragmentManager();
        CategoryDialog alertDialog = new CategoryDialog().newInstance(activity, CategoriesList.get(position), subcategory);
        alertDialog.show(fm, "alertDialog");
    }

    private void initilize(){
        CategoriesList = CategoryDelegate.findAll();
        activity = this;
        listView = (ListView) findViewById(R.id.lvCategories);
        adapter = new CategoryAdapter(this, CategoriesList);
        subcategory = getIntent().getParcelableExtra("Subcategory");
        alertDialogBuilder = new AlertDialog.Builder(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) activity);
    }

}
