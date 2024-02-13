package ru.noname07.lab5.utils;

import java.util.Locale;

public class I18n {
    public static enum Languages {
        en_EN(new Locale("en")),
        ru_RU(new Locale("ru"));

        Locale x;
        Languages(Locale x) {
            this.x = x;
        }

        public Locale get() {
            return this.x;
        }

    }

    

}

