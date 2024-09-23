package com.example.tp4.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<Boolean> loginState = new MutableLiveData<>();

    public LiveData<Boolean> getLoginState() {
        return loginState;
    }

    public void login(String username, String password) {
        if (username.equals("123") && password.equals("123")) {
            loginState.setValue(true);
        } else {
            loginState.setValue(false);
        }
    }

}
