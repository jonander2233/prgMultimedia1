package com.example.tema01.ejercicio03.engranajes;

import java.util.Random;

public class Engranajes {
    public static Boolean caraOCruz(){
        Random random = new Random();
        int numeroRandom = random.nextInt();

        if (numeroRandom % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}
