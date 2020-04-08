package com.example.listmoviepopular.ui.login;

public interface LoginInterface {

    interface View {
        void disableInputs();

        void enableInputs();

        void showProgress();

        void hidePrgress();

        void handleLogin();

        boolean isValidEmail();

        boolean isValidPassword();

        void onLogin();

        void onError(String error);

    }

    interface Presenter {
        void voidOnDestroy();

        void toLogin(String email, String password);
    }

    interface Model {
        void doLogin(String email, String password);
    }

    interface Tasklistener {
        void onSucess();

        void onError(String error);
    }

}