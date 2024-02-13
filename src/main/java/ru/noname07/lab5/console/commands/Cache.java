package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Cache {

    public static class StartCache extends Command {

        public StartCache() {
            super("start_cache", "", false);
        }

        @Override
        public void execute() {
            App.toScriptSave = "src/main/resources/SAVED_SCRIPT.txt";
            System.out.println("Cacing current script started.");
        }

    }

    public static class SaveCache extends Command {

        public SaveCache() {
            super("save_cache", "ption", true);
        }

        @Override
        public void execute() {
            if (!App.toScriptSave.equals("")) {
                App.toScriptSave = "";
                System.out.println("Script was saved in " + App.toScriptSave);
            }
        }

    }

}
