package edu.esprit.delegates;

import java.util.ArrayList;

import edu.esprit.entities.Category;
import edu.esprit.entities.Subcategory;

public class SubCategoryDelegate {
    public static ArrayList<Subcategory> subCategoriesList = null;

    public static ArrayList<Subcategory> findAll(){
        if(subCategoriesList == null){
            subCategoriesList = new ArrayList<>();
            Category g = new Category();
            g.setIdCategory(1);
            g.setLibelle("libelle 1");
            g.setDescription("description 1");
            Subcategory s = new Subcategory();
            s.setIdSubCategory(1);
            s.setDescription("description 1");
            s.setLibelle("SubCat 1");
            s.setCategory(g);
            subCategoriesList.add(s);
            g = new Category();
            g.setIdCategory(2);
            g.setLibelle("libelle 2");
            g.setDescription("description 2");
            s = new Subcategory();
            s.setIdSubCategory(2);
            s.setDescription("description 2");
            s.setLibelle("SubCat 2");
            s.setCategory(g);
            subCategoriesList.add(s);
        }
        return  subCategoriesList;
    }
}
