package com.piskvorky.localization.classes;

import com.piskvorky.localization.enumerations.Languages;

import java.io.*;
import java.util.*;

public class Localization implements com.piskvorky.localization.Localization {
    private Languages currentLocal;
    private Properties prop;



    public Localization() {
        this.currentLocal = Languages.DEFAULT;
        prop = new Properties();
    }

    private void loadFile(Languages loc) throws IOException {
        InputStream stream = new FileInputStream(loc.getFileLoc());
        prop.load(stream);
    }

    @Override
    public void setLocalization(Languages s) {
        currentLocal = s;
        try {
            loadFile(currentLocal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPlayText() {
        String local = prop.getProperty("playText");
        if (local != null){
            return local;
        }
        try {
            loadFile(Languages.DEFAULT);
            local = prop.getProperty("playText");
            return local;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getWonText() {
        String local = prop.getProperty("wonText");
        if (local != null){
            return local;
        }else{
            try {
                loadFile(Languages.DEFAULT);
                local = prop.getProperty("wonText");
                return local;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String errorText() {
        String local = prop.getProperty("errorText");
        if (local != null){
            return local;
        }else{
            try {
                loadFile(Languages.DEFAULT);
                local = prop.getProperty("errorText");
                return local;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
