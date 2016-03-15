package edu.esprit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.esprit.entities.Subcategory;

public class AddSubCategory extends AppCompatActivity {
    private Subcategory subcategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub_category);
        subcategory = new Subcategory();
    }

    public void selectCategory(View v){
        Intent i = new Intent(AddSubCategory.this, SelectCategoryList.class);
        EditText description = (EditText) findViewById(R.id.subcat_input_description);
        EditText libelle = (EditText) findViewById(R.id.subcat_input_label);
        subcategory.setDescription(description.getText().toString());
        subcategory.setLibelle(libelle.getText().toString());
        i.putExtra("Subcategory", subcategory);
        startActivity(i);
    }
}
