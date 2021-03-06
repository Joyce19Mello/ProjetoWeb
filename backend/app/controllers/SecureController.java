package controllers;

import models.Professor;

public class SecureController extends DefaultController{
    public static void autenticacao(Professor professor){
        Professor p = Professor.find("email = :email AND senha = :senha")
                .setParameter("email", professor.email)
                .setParameter("senha", professor.senha)
                .first();

        if(p != null) {
            renderJSON(p);
        } else {
            renderText("Usuário não encontrado!");
        }

    }
}
