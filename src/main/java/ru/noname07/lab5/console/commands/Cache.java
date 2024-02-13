package ru.noname07.lab5.console.commands;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang3.StringUtils;

import ru.noname07.lab5.App;

public class Cache {

    public static class StartCache extends Command {

        public StartCache() {
            super("start_cache", commandsBundle.getString("command.start_cache.description"), false);
        }

        @Override
        public void execute() {
            App.toScriptSave = "src/main/resources/AppData/SAVED_SCRIPT.txt";
            System.out.println(commandsBundle.getString("command.start_cache.execute"));
        }

    }

    public static class SaveCache extends Command {

        public SaveCache() {
            super("save_cache", commandsBundle.getString("command.save_cache.description"), false);
        }

        @Override
        public void execute() {
            if (!App.toScriptSave.equals("")) {
                App.toScriptSave = "";
                System.out.println(commandsBundle.getString("command.save_cache.execute") + App.toScriptSave);
            }
        }

        @Override
        public void execute(String[] args) {
            if (!App.toScriptSave.equals("")) {
                if (StringUtils.isAlphanumeric(args[1])) {
                    try (BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream(App.toScriptSave)); BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream("resources/AppData/"+args[1]+".txt"))) {
                        byte[] bytes = bInputStream.readAllBytes();
                        bInputStream.close();

                        bOutputStream.write(bytes);
                        bOutputStream.close();

                    } catch (IOException e) {
                        // System.err.println(commandsBundle.getString("command.err.incorrect_value"));
                        e.printStackTrace();
                    }

                    App.toScriptSave = "";
                    System.out.println(commandsBundle.getString("command.save_cache.execute") + "resources/AppData/"+args[1]+".txt");
                } else
                    System.err.println(commandsBundle.getString("command.err.incorrect_value"));
            }
        }

    }

}
