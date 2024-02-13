package ru.noname07.lab5.console.commands;

public class Exit extends Command {

    public Exit() {
        super("exit", commandsBundle.getString("command.exit.description"), false);
    }

    @Override
    public void execute() {
        System.out.println(commandsBundle.getString("command.exit.execute"));
        System.exit(0);
    }

}
