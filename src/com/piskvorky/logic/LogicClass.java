package com.piskvorky.logic;

import com.piskvorky.localization.Localization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogicClass implements Logic {
    private Scanner scan = new Scanner(System.in);
    private Board board;
    private int round;
    private Localization local;
    private boolean play = false;
    private int streak;
    private File gameLog;
    private FileWriter fw;
    private int w, h;



    public LogicClass(int w, int h) {
        this.w = w;
        this.h =h;
        this.board = createBoard(w, h);
        this.round = 0;
        this.local = new com.piskvorky.localization.classes.Localization();
        this.streak = 0;
        this.gameLog = new File("data/gameLog.txt");
        try {
            this.fw =new FileWriter(gameLog,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public boolean checkWin(int streak, Cell cell) {
        if (board.checkDiagonal(streak,cell) || board.checkSecondDiagonal(streak,cell) || board.checkLine(streak,cell) || board.checkTopBottom(streak, cell)){
            System.out.println(local.getWonText()+" "+cell.getAnswer());
            try {
                fw.write(local.getWonText()+" "+cell.getAnswer()+"\n");
                fw.write(local.fieldSize()+" "+w+" "+h+"\n");
                fw.write("round: "+round+"\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printBoard(board);
            return true;
        }
        return false;
    }

    @Override
    public void input() {
        if (round%2 == 0){
            System.out.println(local.getPlayText()+" "+Cell.CROSS.getAnswer());
        }else{
            System.out.println(local.getPlayText()+" "+Cell.ROUND.getAnswer());
        }
        printBoard(board);
        int w, h;
        w = scan.nextInt();
        h = scan.nextInt();

        if (w > board.getW() || w < 0) {
            System.out.println(local.errorText());
            //round--;
            return;
        }
        if (h > board.getH() || h < 0) {
            System.out.println(local.errorText());
            //round--;
            return;
        }
        if (board.getCell(w, h) == Cell.ROUND || board.getCell(w, h) == Cell.CROSS) {
            System.out.println(local.errorText());
            //round--;
            return;
        }

        if (round % 2 == 0) {
            board.setVal(w, h, Cell.CROSS);
           play = checkWin(streak,Cell.CROSS);
           round++;
           return;
        }
        board.setVal(w, h, Cell.ROUND);
        play= checkWin(streak,Cell.ROUND);
        round++;
    }

    public boolean isPlay() {
        return play;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public Localization getLocal() {
        return local;
    }
}

