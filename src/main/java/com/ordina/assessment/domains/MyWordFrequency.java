package com.ordina.assessment.domains;

public class MyWordFrequency implements WordFrequency{

    private String word;

    private int frequency;

    public MyWordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

}

