package edu.esprit.delegates;

import java.util.ArrayList;

import edu.esprit.entities.Category;

public class CategoryDelegate {
    public static ArrayList<Category> categoriesList = null;

    public static ArrayList<Category> findAll(){
        if(categoriesList == null){
            categoriesList = new ArrayList<>();
            Category g = new Category();
            g.idCategory = 1;
            g.libelle = "libelle 1";
            g.description = "description 1";
            categoriesList.add(g);
            g = new Category();
            g.idCategory = 2;
            g.libelle = "libelle 2";
            g.description = "description 2";
            categoriesList.add(g);
        }
        return  categoriesList;
    }
}
