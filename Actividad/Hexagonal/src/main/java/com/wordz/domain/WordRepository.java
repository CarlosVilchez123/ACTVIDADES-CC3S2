package com.wordz.domain;

public interface WordRepository {

    String fetchWordByNumber(int number); // aqui se esta colocando el puerto

    int highestWordNumber();
}
