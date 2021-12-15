package com.piskvorky.logic;

public interface Logic {
    Board createBoard(int width, int height);
    void printBoard(Board board);
    boolean checkWin(int streak, Cell cell);
    void input();


}
