package com.soberbee.soberbeenotification;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



public class SignUpFragment extends Fragment {

    final private String parseLoginError = "PARSE_LOGIN_ERROR";

    EditText usernameSignUpText;
    EditText emailSignUpText;
    EditText passwordSignUpText;
    EditText passwordSignUpConfirmText;
    Button signUpButton;
    TextView loginText;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        usernameSignUpText = (EditText) rootView.findViewById(R.id.username_signup_text);
        emailSignUpText = (EditText) rootView.findViewById(R.id.email_signup_text);
        passwordSignUpText = (EditText) rootView.findViewById(R.id.password_signup_text);
        passwordSignUpConfirmText = (EditText) rootView.findViewById(R.id.confirm_signup_text);
        signUpButton = (Button) rootView.findViewById(R.id.sign_btn);
        loginText = (TextView) rootView.findViewById(R.id.login_txt);

        signUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });

        loginText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showOtherFragment();
            }
        });

        return rootView;
    }

    public void showOtherFragment()
    {
        Fragment fragment = new LoginFragment();
        FragmentChangeListener fragmentChangeListener = (FragmentChangeListener)getActivity();
        fragmentChangeListener.replaceFragment(fragment);
    }

    private void signUpUser()
    {
        // Save new user data into Parse.com Data Storage
        String email = String.valueOf(emailSignUpText.getText());
        String username = String.valueOf(emailSignUpText.getText());
        String password = String.valueOf(passwordSignUpText.getText());
        String confirm = String.valueOf(passwordSignUpConfirmText.getText());

        if (username.equals("") || email.equals("") || password.equals("") || confirm.equals("")) {
            Toast.makeText(getActivity(),
                    "Please complete the sign up form",
                    Toast.LENGTH_LONG).show();

        }
        else if(password.compareTo(confirm) != 0) {
            Toast.makeText(getActivity(),
                    "Passwords do not match",
                    Toast.LENGTH_LONG).show();
        }
        else {

            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // Show a simple Toast message upon successful registration
                        Toast.makeText(getActivity(),
                                "Successfully Signed up, please log in.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Log.e(parseLoginError, e.getMessage());
                        Toast.makeText(getActivity(),
                                "Sign up Error", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            });
        }
    }

    @Override
    public String toString()
    {
        return "Sign Up Fragment";
    }

}
