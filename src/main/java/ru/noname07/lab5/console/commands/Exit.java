package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Exit extends Command {

    public Exit() {
        super("exit", App.generalBundle.getString("command.exit.description"), false);
    }

    @Override
    public void execute() {
        System.out.println(App.generalBundle.getString("command.exit.message"));
        System.exit(0);
    }

}
