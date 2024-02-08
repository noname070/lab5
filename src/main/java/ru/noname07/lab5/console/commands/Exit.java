package ru.noname07.lab5.console.commands;

public class Exit extends Command {

    public Exit() {
        super("exit", "complete the program");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
    
}
