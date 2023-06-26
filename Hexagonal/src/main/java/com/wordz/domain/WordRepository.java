package com.wordz.domain;

public interface WordRepository {
    // es eñ puerto
    String fetchWordByNumber(int number);

    int highestWordNumber();
}
