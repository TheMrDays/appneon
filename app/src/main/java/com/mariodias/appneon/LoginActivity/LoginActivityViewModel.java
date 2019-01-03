package com.mariodias.appneon.LoginActivity;

import android.util.Log;

public class LoginActivityViewModel {


    private String password = "";

    // Equando a senha for diferente de 6, adiciona o caracter a string
    public void handlePasswordButtonTap(String typedPasswordNumber) {
        if (this.isPasswordComplete()){
            return ;
        }
        this.password += typedPasswordNumber;
    }


    // Deleta o ultimo caracter da string
    public void handlePasswordCleanButtonTap(){
        if (this.password.isEmpty()){
            return;
        }
        this.password = this.password.substring(0, this.password.length() -1);
    }

    // Retorna o tamanho atual da senha
    public int currentPasswordLenght(){
        return this.password.length();
    }

    // Valida se a senha atingiu o tamanho de 6 caracteres
    public boolean isPasswordComplete(){
            return this.password.length() == 6;
    }

    //Exibe toast somente para efeito de teste
    public String toastMessage(){
        return "Password: " + this.password;
    }

}
