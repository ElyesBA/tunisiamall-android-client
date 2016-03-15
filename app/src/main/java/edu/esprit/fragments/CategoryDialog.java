package edu.esprit.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import edu.esprit.entities.Category;


public class CategoryDialog extends DialogFragment {

    public CategoryDialog(){}

    public static CategoryDialog newInstance(Category c) {
        CategoryDialog f = new CategoryDialog();
        Bundle args = new Bundle();
        args.putInt("id", c.idCategory);
        args.putString("label", c.libelle);
        f.setArguments(args);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Confirmation");
        alertDialogBuilder.setMessage("select " + getArguments().getString("label") + " ?");
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
