package com.piskvorky.localization.enumerations;

public enum Languages {
    CZECH("./data/CZECH.properties"),
    ENGLISH("./data/ENGLISH.properties"),
    DEFAULT("./data/CZECH.properties");

    private String fileLoc;

    Languages(String fileLoc) {
        this.fileLoc = fileLoc;
    }

    public String getFileLoc() {
        return fileLoc;
    }
}
