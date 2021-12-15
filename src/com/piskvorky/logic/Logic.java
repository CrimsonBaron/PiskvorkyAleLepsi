package com.piskvorky.logic;

public interface Logic {
    Board createBoard(int width, int height);
    void printBoard(Board board);
    boolean checkWin(int w, int h, Cell cell);
    void input();


}
