package com.piskvorky.localization;

import com.piskvorky.localization.enumerations.Languages;

public interface Localization {
    void setLocalization(Languages s);
    String getPlayText();
    String getWonText();
    String errorText();
}
