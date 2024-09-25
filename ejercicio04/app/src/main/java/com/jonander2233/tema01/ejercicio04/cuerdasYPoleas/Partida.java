package com.jonander2233.tema01.ejercicio04.cuerdasYPoleas;

public class Partida {
    private ElementosJuego seleccionJugador;
    private ElementosJuego seleccionCpu;
    private EstadosJuego resultado;

    public Partida(ElementosJuego seleccionJugador, ElementosJuego seleccionCpu, EstadosJuego resultado) {
        this.seleccionJugador = seleccionJugador;
        this.seleccionCpu = seleccionCpu;
        this.resultado = resultado;
    }

    public ElementosJuego getSeleccionJugador() {
        return seleccionJugador;
    }

    public ElementosJuego getSeleccionCpu() {
        return seleccionCpu;
    }

    public EstadosJuego getResultado() {
        return resultado;
    }
}
