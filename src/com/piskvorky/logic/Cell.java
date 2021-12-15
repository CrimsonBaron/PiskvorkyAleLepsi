package com.piskvorky.logic;

public enum Cell {
    EMPTY(' '),
    CROSS('x'),
    ROUND('o');

    private char input;

    Cell(char answer) {
        this.input = answer;
    }

    public char getAnswer() {
        return input;
    }

    public void setAnswer(char answer) {
        this.input = answer;
    }
}
