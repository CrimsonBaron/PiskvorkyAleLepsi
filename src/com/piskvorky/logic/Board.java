package com.piskvorky.logic;

public class Board {

    private Cell[][] gameBoard;

    public Board(Cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setVal(int w, int h, Cell cell) {
        gameBoard[w][h] = cell;
    }

    public Cell getCell(int w, int h) {return gameBoard[w][h];}

    public boolean checkDiagonal(int streak, Cell symbol) {
        int w = 0, h = 0;
        int localStreak = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            if (getCell(w,h) == symbol){
                localStreak++;
            }else{
                localStreak = 0;
            }
            if (localStreak == streak){
                return true;
            }
            w++;
            h++;
        }
        return false;
    }

    public boolean checkSecondDiagonal(int streak, Cell symbol){
        int w = gameBoard.length-1 , h = 0;
        int localStreak = 0;
        for (int i = 0; i < gameBoard.length ; i++) {
            if (getCell(w,h) == symbol){
                localStreak++;
            }else{
                localStreak = 0;
            }
            if (localStreak == streak){
                return true;
            }
            w--;
            h++;
        }
        return false;
    }

    public boolean checkLine(int streak, Cell symbol){
        int localStreak = 0;
        for (int i = 0; i < gameBoard.length ; i++) {
            for (int j = 0; j <gameBoard[i].length ; j++) {
                if (getCell(i,j) == symbol){
                    localStreak++;
                }else{
                    localStreak = 0;
                }
                if (localStreak == streak){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTopBottom(int streak, Cell symbol){
        int localStreak =0;

        for (int i = 0; i < gameBoard[0].length ; i++) {
            for (int j = 0; j <  gameBoard.length ; j++) {
                if (getCell(j,i) == symbol){
                    localStreak++;
                }else{
                    localStreak = 0;
                }
                if (localStreak == streak){
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        System.out.print("   ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j].getAnswer() + " | ");
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
