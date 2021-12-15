package com.piskvorky.logic;

public enum Board {
    EMPTY(' '),
    CROSS('x'),
    ROUND('o');

    private char input;

    Board(char answer) {
        this.input = answer;
    }

    public char getAnswer() {
        return input;
    }

    public void setAnswer(char answer) {
        this.input = answer;
    }
}
