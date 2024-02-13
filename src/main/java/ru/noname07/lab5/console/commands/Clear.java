package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Clear extends Command {

    public Clear() {
        super("clear", Command.commandsBundle.getString("command.clear.description"), false);
    }

    @Override
    public void execute() {
        App.collection.getData().clear();
        System.out.println(Command.commandsBundle.getString("command.clear.execute"));
    }

}
