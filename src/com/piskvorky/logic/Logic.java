package com.piskvorky.logic;

public interface Logic {
    char[][] createBoard(int width, int height);
    void printBoard();
    boolean checkWin();
    void input();


}
