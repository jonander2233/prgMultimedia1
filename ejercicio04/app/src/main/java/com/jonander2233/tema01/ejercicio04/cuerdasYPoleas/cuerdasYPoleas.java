package com.jonander2233.tema01.ejercicio04.cuerdasYPoleas;

import java.util.Random;

public class cuerdasYPoleas {
    public EstadosJuego jugarVsCpu(ElementosJuego jugada){
        Random random = new Random();
        int cpu = random.nextInt(3);
        ElementosJuego cpuJugada = null;
        switch (cpu){
            case 0:
                cpuJugada = ElementosJuego.PIEDRA;
                break;
            case 1:
                cpuJugada = ElementosJuego.PAPEL;
                break;
            case 2:
                cpuJugada = ElementosJuego.TIJERA;
                break;
        }

        if(cpuJugada == ElementosJuego.PIEDRA && jugada == ElementosJuego.TIJERA){
            return EstadosJuego.PERDER;
        } else if (cpuJugada == ElementosJuego.PAPEL && jugada == ElementosJuego.TIJERA){
            return EstadosJuego.GANAR;
        } else if (cpuJugada == ElementosJuego.TIJERA && jugada == ElementosJuego.TIJERA) {
            return EstadosJuego.EMPATAR;
        } else if (cpuJugada == ElementosJuego.PIEDRA && jugada == ElementosJuego.PAPEL){
            return EstadosJuego.GANAR;
        } else if (cpuJugada == ElementosJuego.PAPEL && jugada == ElementosJuego.PAPEL){
            return EstadosJuego.EMPATAR;
        } else if (cpuJugada == ElementosJuego.TIJERA && jugada == ElementosJuego.PAPEL) {
            return EstadosJuego.PERDER;
        } else if (cpuJugada == ElementosJuego.PIEDRA && jugada == ElementosJuego.PIEDRA){
            return EstadosJuego.EMPATAR;
        } else if (cpuJugada == ElementosJuego.PAPEL && jugada == ElementosJuego.PIEDRA){
            return EstadosJuego.PERDER;
        } else if (cpuJugada == ElementosJuego.TIJERA && jugada == ElementosJuego.PIEDRA) {
            return EstadosJuego.GANAR;
        }
        return null;
    }
}
