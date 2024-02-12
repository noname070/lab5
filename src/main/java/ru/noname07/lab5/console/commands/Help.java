package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.App;

public class Help extends Command {

    public Help() {
        super("help", "display help for available commands", false);
    }

    @Override
    public void execute() {
        for (Command command : App.console.getCommandList().values()) {
            System.out.printf("%-40s\t:\t%s %n \n", command.getName(), command.getDescription());
        }
    }

}
