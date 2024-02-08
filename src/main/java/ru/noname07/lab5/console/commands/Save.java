package ru.noname07.lab5.console.commands;

public class Save extends Command {

    public Save() {
        super("save", "save collection to file");
    }

    @Override
    public void execute() { // TODO
        System.out.println("Collection saved to file.");
    }

}
