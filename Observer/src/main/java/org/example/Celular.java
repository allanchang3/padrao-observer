package org.example;

import java.util.Observable;
import java.util.Observer;

public class Celular implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Celular(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void registrar (EstacaoMeteorologica estacao){
        estacao.addObserver(this);
    }

    public void update(Observable estacao, Object arg1) {
        this.ultimaNotificacao = this.nome + ", clima atualizado: " + estacao.toString();
    }

}
