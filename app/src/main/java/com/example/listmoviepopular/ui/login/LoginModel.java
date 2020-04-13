package com.example.listmoviepopular.ui.login;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginModel implements LoginContract.Model {

    private LoginContract.Tasklistener listener;
    private FirebaseAuth auth;

    public LoginModel(LoginContract.Tasklistener listener) {
        this.listener = listener;
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void doLogin(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    listener.onSucess();
                } else { if (task.getException()!= null) listener.onError(task.getException().getMessage());
                }
            }
        });
    }
}