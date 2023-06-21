package org.example;

import java.util.Random;

public class WordSeleccion {
    private WordRepository word;
    public WordSeleccion(WordRepository word){
        this.word =word;
    }

    public String SeleccionRandom(){
        Random rand = new Random();

        return String.format("La palabra random es: %s", word.fetchWordByNumber(rand.nextInt(1,3)));
    }
}
