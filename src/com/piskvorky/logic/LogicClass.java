package com.piskvorky.logic;

import com.piskvorky.localization.Localization;

import java.util.Scanner;

public class LogicClass implements Logic {
    private Scanner scan = new Scanner(System.in);
    private Board board;
    private int round;
    private Localization local;
    private boolean play = false;


    public LogicClass(int w, int h) {
        this.board = createBoard(w, h);
        this.round = 0;
        this.local = new com.piskvorky.localization.classes.Localization();
    }

    @Override
    public Board createBoard(int width, int height) {
        Board board = new Board(new Cell[width][height]);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board.setVal(i, j, Cell.EMPTY);
            }
        }
        return board;
    }

    @Override
    public void printBoard(Board board) {
        board.print();
    }

    @Override
    public boolean checkWin(int w, int h, Cell cell) {
        if (board.getCell(w-1,h-1) == cell && board.getCell(w+1,h+1) == cell ){
            System.out.println(local.getWonText()+" "+cell.toString());
            return true;
        }

        return false;
    }

    @Override
    public void input() {
        printBoard(this.board);
        int w, h;
        w = scan.nextInt();
        h = scan.nextInt();

        if (w > board.getW() || w < 0) {
            System.out.println(local.errorText());
            round--;
            return;
        }
        if (h > board.getH() || h < 0) {
            System.out.println(local.errorText());
            round--;
            return;
        }
        if (board.getCell(w, h) == Cell.ROUND || board.getCell(w, h) == Cell.CROSS) {
            System.out.println(local.errorText());
            round--;
            return;
        }

        if (round % 2 == 0) {
            board.setVal(w, h, Cell.CROSS);
           play = checkWin(w,h,Cell.CROSS);

            round++;
        }
        board.setVal(w, h, Cell.ROUND);

        play= checkWin(w,h,Cell.ROUND);

        round++;
    }

    public boolean isPlay() {
        return play;
    }
}
