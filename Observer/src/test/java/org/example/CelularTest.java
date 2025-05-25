package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CelularTest {

    @Test
    void deveNotificarUmCelular() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("25°C", "60%", "Ensolarado");
        Celular Celular = new Celular("Celular");
        Celular.registrar(estacao);
        estacao.atualizarClima("22°C", "70%", "Nublado");
        Assertions.assertEquals("Celular, clima atualizado: Clima{temperatura='22°C', umidade='70%', condicao='Nublado'}", Celular.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCelulars() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("25°C", "60%", "Ensolarado");
        Celular Celular1 = new Celular("Celular1");
        Celular Celular2 = new Celular("Celular2");
        Celular1.registrar(estacao);
        Celular2.registrar(estacao);
        estacao.atualizarClima("22°C", "70%", "Nublado");
        Assertions.assertEquals("Celular1, clima atualizado: Clima{temperatura='22°C', umidade='70%', condicao='Nublado'}", Celular1.getUltimaNotificacao());
        Assertions.assertEquals("Celular2, clima atualizado: Clima{temperatura='22°C', umidade='70%', condicao='Nublado'}", Celular2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCelular() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("25°C", "60%", "Ensolarado");
        Celular Celular = new Celular("Celular");
        estacao.atualizarClima("22°C", "70%", "Nublado");
        Assertions.assertNull(Celular.getUltimaNotificacao());
    }

    @Test
    void deveNotificarCelularDaEstacaoA() {
        EstacaoMeteorologica estacaoA = new EstacaoMeteorologica("25°C", "60%", "Ensolarado");
        EstacaoMeteorologica estacaoB = new EstacaoMeteorologica("28°C", "50%", "Sol com nuvens");
        Celular Celular1 = new Celular("Celular1");
        Celular Celular2 = new Celular("Celular2");
        Celular1.registrar(estacaoA);
        Celular2.registrar(estacaoB);
        estacaoA.atualizarClima("20°C", "80%", "Chuva");
        Assertions.assertEquals("Celular1, clima atualizado: Clima{temperatura='20°C', umidade='80%', condicao='Chuva'}", Celular1.getUltimaNotificacao());
        Assertions.assertNull(Celular2.getUltimaNotificacao());
    }
}
