package com.jonander2233.tema01.ejercicio02.mathUtils;

public class Meth {
    public static long factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }
}
