package com.piskvorky.logic;

public class Board {

    private Cell[][] gameBoard;

    public Board(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setVal(int w, int h, Cell cell) {
        gameBoard[w][h] = cell;
    }

    public Cell getCell(int w, int h){
        return gameBoard[w][h];
    }

    public void print() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j].getAnswer() + "|");
            }
            System.out.print("\n");
        }
    }

    public int getH() {
        return gameBoard.length;
    }

    public int getW() {
        return gameBoard[0].length;
    }


}
