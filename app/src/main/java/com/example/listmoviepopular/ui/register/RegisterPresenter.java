package com.example.listmoviepopular.ui.register;

public class RegisterPresenter implements RegisterContract.Presenter, RegisterContract.Tasklistener {

    private RegisterContract.View view;
    private RegisterContract.Model model;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        model = new RegisterModel(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void doRegister(String name, String email, String password) {
        if (view != null) {
            view.disableInputs();
            view.showProgress();
        }
        model.onRegister(name, email, password);
    }

    @Override
    public void onSucess() {
        if (view != null) {
            view.enableInputs();
            view.hidePrgress();
            view.onLogin();
        }
    }

    @Override
    public void onError(String error) {
        if (view != null) {
            view.enableInputs();
            view.hidePrgress();
            view.onError(error);
        }
    }
}