package edu.esprit.delegates;

import java.util.ArrayList;

import edu.esprit.entities.Category;

public class CategoryDelegate {
    public static ArrayList<Category> categoriesList = null;

    public static ArrayList<Category> findAll(){
        if(categoriesList == null){
            categoriesList = new ArrayList<>();
            Category g = new Category();
            g.setIdCategory(1);
            g.setLibelle("libelle 1");
            g.setDescription("description 1");
            categoriesList.add(g);
            g = new Category();
            g.setIdCategory(2);
            g.setLibelle("libelle 2");
            g.setDescription("description 2");
            categoriesList.add(g);
        }
        return  categoriesList;
    }
}
