package com.example.listmoviepopular.ui.register;

public interface RegisterInterface {
    interface View {
        void disableInputs();
        void enableInputs();

        void showProgress();
        void hidePrgress();

        void handleRegister();
        boolean validateViews();

        void onError(String error);
        void onLogin();

    }

    interface Presenter {
        void onDestroy();
        void doRegister(String name, String email, String password);
    }

    interface Model {
        void onRegister(String name, String email, String password);
    }

    interface Tasklistener {
        void onSucess();
        void onError(String error);
    }

}
