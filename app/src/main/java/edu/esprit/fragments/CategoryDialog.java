package edu.esprit.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import edu.esprit.entities.Category;
import edu.esprit.entities.Subcategory;


public class CategoryDialog extends DialogFragment {

    public CategoryDialog(){}

    public static CategoryDialog newInstance(Category c, Subcategory s) {
        CategoryDialog f = new CategoryDialog();
        Bundle args = new Bundle();
        args.putParcelable("Category", c);
        args.putParcelable("Subcategory", s);
        f.setArguments(args);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Confirmation");
        Category c = getArguments().getParcelable("Category");
        Subcategory s = getArguments().getParcelable("Subcategory");
        alertDialogBuilder.setMessage("Label: " + s.getLibelle() + "\n" +
                "Description: " + s.getDescription() + "\n" +
                "Category: " + c.getLibelle());
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        return alertDialogBuilder.create();
    }
}
