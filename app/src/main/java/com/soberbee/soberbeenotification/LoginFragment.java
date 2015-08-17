package com.soberbee.soberbeenotification;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class LoginFragment extends Fragment  {


    EditText usernameLoginText;
    EditText passwordLoginText;
    Button loginButton;
    TextView signUpText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        usernameLoginText = (EditText) rootView.findViewById(R.id.username_login_text);
        passwordLoginText = (EditText) rootView.findViewById(R.id.password_login_text);
        loginButton = (Button) rootView.findViewById(R.id.login_btn);
        signUpText = (TextView) rootView.findViewById(R.id.sign_up_txt);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signUpText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showOtherFragment();
            }
        });

        return rootView;
    }

    public void showOtherFragment()
    {
        Fragment fragment = new SignUpFragment();
        FragmentChangeListener fragmentChangeListener = (FragmentChangeListener) getActivity();
        fragmentChangeListener.replaceFragment(fragment);
    }

    @Override
    public String toString()
    {
        return "Login Fragment";
    }

}
