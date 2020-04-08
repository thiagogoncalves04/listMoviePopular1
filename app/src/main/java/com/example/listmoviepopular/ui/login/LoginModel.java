package com.example.listmoviepopular.ui.login;

public class LoginModel implements LoginInterface.Model {

    private LoginInterface.Tasklistener listener;

    public LoginModel(LoginInterface.Tasklistener listener) {
        this.listener = listener;
    }

    @Override
    public void doLogin(String email, String password) {

    }
}
