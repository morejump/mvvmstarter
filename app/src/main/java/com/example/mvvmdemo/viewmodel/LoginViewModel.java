package com.example.mvvmdemo.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemo.model.User;


public class LoginViewModel extends BaseObservable {
    private User user;

    private String successMessage = "Login was successful";

    @Bindable
    public String toastMessage = null;

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        setToastMessage(successMessage + " " + user.getEmail() + " " + user.getPassword());
    }
}
