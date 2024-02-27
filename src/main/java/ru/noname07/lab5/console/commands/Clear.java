package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

/**
 * Realisation for "clear" command
 * @see Command
 */ 
public class Clear extends Command {

    public Clear() {
        super("clear", App.generalBundle.getString("command.clear.description"), false);
    }

    @Override
    public void execute() {
        App.collection.getData().clear();
        System.out.println(App.generalBundle.getString("command.clear.execute"));
    }

}
