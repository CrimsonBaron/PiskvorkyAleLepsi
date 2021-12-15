package com.piskvorky.app;

import com.piskvorky.localization.classes.Localization;
import com.piskvorky.localization.enumerations.Languages;

import com.piskvorky.logic.Logic;
import com.piskvorky.logic.LogicClass;

public class Application {
    LogicClass game = new LogicClass(5,5);
    public Application() {

    }
    public void Run(String[] args){
       while (game.isPlay()){
           game.input();
       }
    }

}
