package org.example;

import java.util.Observable;

public class EstacaoMeteorologica extends Observable {
    private String temperatura;
    private String umidade;
    private String condicao;

    public EstacaoMeteorologica(String temperatura, String umidade, String condicao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.condicao = condicao;
    }

    public void atualizarClima(String temperatura, String umidade, String condicao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.condicao = condicao;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "Clima{temperatura='" + temperatura + "', umidade='" + umidade + "', condicao='" + condicao + "'}";
    }

}
