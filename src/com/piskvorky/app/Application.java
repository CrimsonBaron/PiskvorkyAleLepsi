package com.piskvorky.app;

import com.piskvorky.localization.classes.Localization;
import com.piskvorky.localization.enumerations.Languages;

import com.piskvorky.logic.Logic;
import com.piskvorky.logic.LogicClass;

import java.util.Scanner;

public class Application {
    private Scanner sc = new Scanner(System.in);
    LogicClass game;
    public Application() {

    }
    public void Run(String[] args){
        System.out.println("Select lingo: czech, english : 0 1");
        int lingo = sc.nextInt();
        Languages localLingos = null;
        if (lingo == 0){
            localLingos = Languages.CZECH;
        }else{
            localLingos = Languages.ENGLISH;
        }
        System.out.println("select field size and max streak: w h streak");
        int w = sc.nextInt(), h = sc.nextInt(),streak = sc.nextInt() ;

        game = new LogicClass(w,h);
        game.setStreak(streak);
        game.getLocal().setLocalization(localLingos);

       while (!game.isPlay()){
           game.input();
       }
    }

}
