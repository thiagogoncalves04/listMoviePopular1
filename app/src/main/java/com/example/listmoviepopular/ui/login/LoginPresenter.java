package com.example.listmoviepopular.ui.login;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Tasklistener {
    private LoginContract.View view;
    private LoginContract.Model model;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void toLogin(String email, String password) {
        if(view!=null){
            view.disableInputs();
            view.showProgress();
            model.doLogin(email, password);
        }
         model.doLogin(email, password);
    }

    @Override
    public void onSucess() {
        if(view!=null){
            view.enableInputs();
            view.hidePrgress();
            view.onLogin();
        }
    }

    @Override
    public void onError(String error) {
        if(view!=null){
            view.enableInputs();
            view.hidePrgress();
            view.onError(error);
        }
    }
}