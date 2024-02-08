package ru.noname07.lab5.console.commands;

import ru.noname07.lab5.console.Console;

public class Help extends Command {

    public Help() {
        super("help", "display help for available commands");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        for (Command command : Console.getCommandList().values()) {
            System.out.printf("%-40s\t:\t%s %n \n", command.getName(), command.getDescription());
        }
    }

}
