package ru.noname07.lab5.console.commands;

public class Exit extends Command {

    public Exit() {
        super("exit", "complete the program");
    }

    @Override
    public void execute() {
        System.out.println("bb +250");
        System.exit(0);
    }
    
}
