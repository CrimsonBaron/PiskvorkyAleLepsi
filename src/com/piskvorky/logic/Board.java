package com.piskvorky.logic;

public enum Board {
    EMPTY(' '),
    CROSS('x'),
    ROUND('o');

    private char answer;

    Board(char answer) {
        this.answer = answer;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }
}
