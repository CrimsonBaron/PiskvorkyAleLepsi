package com.piskvorky.app;

import com.piskvorky.localization.classes.Localization;
import com.piskvorky.localization.enumerations.Languages;

public class Application {
    public Application() {

    }
    Localization loc=new Localization();
    public void Run(String[] args){
        loc.setLocalization(Languages.DEFAULT);
        System.out.println(loc.getPlayText());

    }

}
