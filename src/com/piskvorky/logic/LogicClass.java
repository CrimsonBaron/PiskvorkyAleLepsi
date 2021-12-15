package com.piskvorky.logic;

import java.util.Scanner;

public class LogicClass implements Logic {
    Scanner scan = new Scanner(System.in);


    @Override
    public char[][] createBoard(int width, int height) {
        char[][] board = new char[width][height];

 return board;
    }

    @Override
    public void printBoard() {

    }

   

    @Override
    public boolean checkWin() {
        return false;
    }

    @Override
    public void input() {

    }
}
