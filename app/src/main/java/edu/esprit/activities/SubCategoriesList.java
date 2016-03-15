package edu.esprit.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import edu.esprit.adapters.SubCategoryAdapter;
import edu.esprit.delegates.SubCategoryDelegate;
import edu.esprit.entities.Subcategory;

public class SubCategoriesList extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemClickListener {
    ArrayList<Subcategory> SubCategoriesList;
    Activity activity;
    ListView listView;
    SubCategoryAdapter adapter;
    AlertDialog.Builder alertDialogBuilder;
    Subcategory selectedSubCategory = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories_list);
        initilize();
    }


    private void initilize(){
        SubCategoriesList = SubCategoryDelegate.findAll();
        activity = this;
        listView = (ListView) findViewById(R.id.lvSubCategories);
        adapter = new SubCategoryAdapter(this, SubCategoriesList);
        alertDialogBuilder = new AlertDialog.Builder(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener)activity);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sub_category_delete_menu_item:
                adapter.remove(selectedSubCategory);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedSubCategory = (Subcategory) listView.getItemAtPosition(position);
        PopupMenu popup = new PopupMenu(activity, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener)activity);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.sub_category_menu, popup.getMenu());
        popup.show();
    }
}
