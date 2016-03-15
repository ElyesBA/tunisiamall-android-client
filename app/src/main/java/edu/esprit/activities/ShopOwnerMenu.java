package edu.esprit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.PopupMenu;

public class ShopOwnerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_owner_menu);
    }

    public void ShopOwnerSubCategories(View v){
        Intent i = new Intent(ShopOwnerMenu.this, SubCategoriesList.class);
        startActivity(i);
    }

    public void ShopOwnerStores(View v){
        /*Intent i = new Intent(ShopOwnerMenu.this, );
        startActivity(i);*/
    }
}
