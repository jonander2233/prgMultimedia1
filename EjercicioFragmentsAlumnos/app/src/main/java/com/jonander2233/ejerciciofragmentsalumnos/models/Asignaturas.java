package com.jonander2233.ejerciciofragmentsalumnos.models;

public enum Asignaturas {
    AAD("Acceso a Datos"),
    DDI("Desarrollo de Interfaces"),
    PMDM("Programación Multiplataforma"),
    PSP("Programación de Servicios y Procesos"),
    SGE("Sistemas de Gestión Empresarial"),
    EIE("Empresa e Iniciativa Emprendedora"),
    ANG("Angles");

    private final String nombreAsignatura;

    Asignaturas(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
}

