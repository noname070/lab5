package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Info extends Command {

    public Info() {
        super("info", Command.commandsBundle.getString("command.info.description"), false);
    }

    @Override
    public void execute() { // TODO ?
        if (!App.collection.getData().isEmpty()) {
            System.out.printf(Command.commandsBundle.getString("command.help.execute"),
                    App.collection.getData().getClass().getName(),
                    App.collection.getData().size());
        } else {
            System.err.println(Command.commandsBundle.getString("command.err.empty"));
        }
    }

}
