package com.example.listmoviepopular.ui.login;

public class LoginPresenter implements LoginInterface.Presenter, LoginInterface.Tasklistener {
    private LoginInterface.View view;
    private LoginInterface.Model model;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void voidOnDestroy() {
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
