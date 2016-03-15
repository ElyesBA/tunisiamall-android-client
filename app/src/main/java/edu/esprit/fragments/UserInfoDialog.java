package edu.esprit.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.esprit.activities.R;
import edu.esprit.entities.User;

public class UserInfoDialog extends DialogFragment {

    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }

    public UserInfoDialog() {
    }

    public static UserInfoDialog newInstance(User user) {
        UserInfoDialog frag = new UserInfoDialog();
        Bundle args = new Bundle();
        /*args.putString("firstName",user.getFirstName());
        args.putString("lastName",user.getLastName());
        args.putString("gender",user.getGender());
        args.putString("mail",user.getMail());
        args.putString("phone",user.getPhone());*/
        args.putParcelable("User", user);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details, container);
        getDialog().setTitle("User Details");
        User user = getArguments().getParcelable("User");
        TextView text = (TextView) view.findViewById(R.id.user_details_first);
        text.setText(user.getFirstName());
        text = (TextView) view.findViewById(R.id.user_details_last);
        text.setText(user.getLastName());
        text = (TextView) view.findViewById(R.id.user_details_gender);
        if(user.getGender() == "f"){
            text.setText("Female");
        }
        else{
            text.setText("Male");
        }
        text = (TextView) view.findViewById(R.id.user_details_mail);
        text.setText(user.getMail());
        text = (TextView) view.findViewById(R.id.user_details_phone);
        text.setText(user.getPhone());
        return view;
    }

}
