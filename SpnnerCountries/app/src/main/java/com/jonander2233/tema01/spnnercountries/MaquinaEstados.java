package com.jonander2233.tema01.spnnercountries;

public class MaquinaEstados {
    private Estados[][] maquinaEstados = {
            {Estados.ENCENDIDO, Estados.EN_PROCESO},
            {Estados.EN_PROCESO, Estados.APAGADO},
            {Estados.APAGADO, Estados.ENCENDIDO}
    };
}
