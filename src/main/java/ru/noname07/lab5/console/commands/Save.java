package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Save extends Command {

    public Save() {
        super("save", Command.commandsBundle.getString("command.save.description"), false);
    }

    @Override
    public void execute() {
        if (!App.collection.getData().isEmpty()) {
            App.collection.saveData();
            System.out.println(Command.commandsBundle.getString("command.save.execute"));
        } else {System.err.println(Command.commandsBundle.getString("command.err.empty"));}
    }

}
