package edu.esprit.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import edu.esprit.adapters.SubCategoryAdapter;
import edu.esprit.delegates.SubCategoryDelegate;
import edu.esprit.entities.Subcategory;

public class SubCategoriesList extends AppCompatActivity {
    private ArrayList<Subcategory> SubCategoriesList;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories_list);
        populateList();
    }

    private void populateList() {
        SubCategoriesList = SubCategoryDelegate.findAll();
        SubCategoryAdapter adapter = new SubCategoryAdapter(this, SubCategoriesList);
        ListView listView = (ListView) findViewById(R.id.lvSubCategories);
        listView.setAdapter(adapter);
        alertDialogBuilder = new AlertDialog.Builder(this);
    }

}
